package dev.windly.aweather.weather.domain

import dev.windly.aweather.weather.domain.model.CurrentWeather
import dev.windly.aweather.weather.network.model.CurrentWeatherDto
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import dev.windly.limbo.mapstruct.CleanCodeMapper
import org.mapstruct.Mapper

@Mapper
interface WeatherMapper :
  CleanCodeMapper<CurrentWeatherDto, CurrentWeatherEntity, CurrentWeather> {

  // TODO: 14.03.2023
  //  Define mapping rules due to the necessity of flattening
  //  objects for persistence.
}
