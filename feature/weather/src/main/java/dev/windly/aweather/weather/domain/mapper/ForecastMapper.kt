package dev.windly.aweather.weather.domain.mapper

import dev.windly.aweather.weather.network.model.CurrentWeatherDto
import dev.windly.aweather.weather.persistence.model.WeatherEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastMapper @Inject constructor(
  val current: CurrentWeatherMapper,
  private val weather: WeatherMapper,
) {

  /**
   * Maps the [CurrentWeatherDto.weather] into a collection of [WeatherEntity]
   * and makes sure the [WeatherEntity.currentId] is properly set to the id
   * of the referenced parent object.
   */
  fun mapDescriptions(dto: CurrentWeatherDto): List<WeatherEntity> =
    weather
      .mapDtoListToEntityList(dto.weather)
      .onEach { it.currentId = dto.id }
}
