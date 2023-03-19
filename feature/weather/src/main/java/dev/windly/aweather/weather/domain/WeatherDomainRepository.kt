package dev.windly.aweather.weather.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.weather.SearchCriteria
import dev.windly.aweather.weather.TrimmedCoordinates
import dev.windly.aweather.weather.WeatherRepository
import dev.windly.aweather.weather.domain.mapper.ForecastMapper
import dev.windly.aweather.weather.domain.model.CurrentWeather
import dev.windly.aweather.weather.network.CurrentWeatherApi
import dev.windly.aweather.weather.network.model.CurrentWeatherDto
import dev.windly.aweather.weather.persistence.CurrentWeatherDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherDomainRepository @Inject constructor(
  private val api: CurrentWeatherApi,
  private val configuration: Configuration,
  private val dao: CurrentWeatherDao,
  private val mapper: ForecastMapper,
  private val trimmed: TrimmedCoordinates,
) : WeatherRepository {

  override fun downloadForecast(criteria: SearchCriteria): Completable =
    api
      .getCurrentWeather(
        latitude = criteria.latitude,
        longitude = criteria.longitude,
        language = criteria.language,
        units = criteria.units,
        appId = configuration.openWeatherAppId(),
      )
      .flatMapCompletable(::cacheForecast)
      .subscribeOn(Schedulers.io())

  private fun cacheForecast(dto: CurrentWeatherDto): Completable =
    Completable.fromAction {
      val forecast = mapper.current.mapDtoToEntity(dto)
      val coordinates = mapper.mapCoordinates(dto)
      val descriptions = mapper.mapDescriptions(dto)
      dao.insert(forecast, descriptions)
      trimmed.accept(coordinates)
    }

  override fun observeWeather(criteria: SearchCriteria): Flowable<CurrentWeather> =
    dao.observeWeather(
      latitude = criteria.latitude,
      longitude = criteria.longitude,
    )
      .map(mapper.current::mapEntityToDomain)
      .subscribeOn(Schedulers.io())
}
