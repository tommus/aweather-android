package dev.windly.aweather.weather.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.weather.SearchCriteria
import dev.windly.aweather.weather.WeatherRepository
import dev.windly.aweather.weather.domain.model.CurrentWeather
import dev.windly.aweather.weather.network.CurrentWeatherApi
import dev.windly.aweather.weather.persistence.CurrentWeatherDao
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherDomainRepository @Inject constructor(
  private val api: CurrentWeatherApi,
  private val configuration: Configuration,
  private val dao: CurrentWeatherDao,
  private val mapper: WeatherMapper
) : WeatherRepository {

  override fun downloadForecast(criteria: SearchCriteria): Completable =
    api
      .getCurrentWeather(
        latitude = criteria.latitude,
        longitude = criteria.longitude,
        units = criteria.units,
        appId = configuration.openWeatherAppId(),
      )
      .map(mapper::mapDtoToEntity)
      .flatMapCompletable(::saveForecast)
      .subscribeOn(Schedulers.io())

  private fun saveForecast(entity: CurrentWeatherEntity): Completable =
    Completable
      .fromAction { dao.insert(entity) }
      .subscribeOn(Schedulers.io())

  override fun observeWeather(criteria: SearchCriteria): Flowable<CurrentWeather> =
    dao.observeWeather(
      latitude = criteria.latitude,
      longitude = criteria.longitude
    )
      .map(mapper::mapEntityToDomain)
      .subscribeOn(Schedulers.io())
}
