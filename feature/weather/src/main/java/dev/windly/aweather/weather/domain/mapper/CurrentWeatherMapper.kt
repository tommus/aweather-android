package dev.windly.aweather.weather.domain.mapper

import dev.windly.aweather.weather.domain.model.CurrentWeather
import dev.windly.aweather.weather.network.model.CurrentWeatherDto
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import dev.windly.aweather.weather.persistence.view.CurrentWeatherView
import dev.windly.limbo.mapstruct.DtoToEntityMapper
import dev.windly.limbo.mapstruct.EntityToModelMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface CurrentWeatherMapper :
  DtoToEntityMapper<CurrentWeatherDto, CurrentWeatherEntity>,
  EntityToModelMapper<CurrentWeatherView, CurrentWeather> {

  @Mappings(value = [
    Mapping(source = "current", target = "."),
    Mapping(source = "weather", target = "weather"),
  ])
  override fun mapEntityToDomain(entity: CurrentWeatherView): CurrentWeather
}
