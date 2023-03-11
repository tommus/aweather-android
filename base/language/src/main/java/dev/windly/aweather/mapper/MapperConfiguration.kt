package dev.windly.aweather.mapper

import org.mapstruct.MapperConfig
import org.mapstruct.NullValueCheckStrategy.ALWAYS
import org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT
import org.mapstruct.ReportingPolicy.IGNORE

@MapperConfig(
  nullValueMappingStrategy = RETURN_DEFAULT,
  nullValueCheckStrategy = ALWAYS,
  unmappedTargetPolicy = IGNORE
)
interface MapperConfiguration
