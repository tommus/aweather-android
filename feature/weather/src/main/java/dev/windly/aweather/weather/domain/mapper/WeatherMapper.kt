package dev.windly.aweather.weather.domain.mapper

import dev.windly.aweather.weather.network.model.WeatherDto
import dev.windly.aweather.weather.persistence.model.WeatherEntity
import dev.windly.limbo.mapstruct.DtoToEntityMapper
import org.mapstruct.Mapper

@Mapper
interface WeatherMapper : DtoToEntityMapper<WeatherDto, WeatherEntity>
