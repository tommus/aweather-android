package dev.windly.aweather.geocoding.domain

import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.network.model.LocationDto
import dev.windly.aweather.geocoding.persistence.model.LocationEntity
import dev.windly.limbo.mapstruct.CleanCodeMapper
import org.mapstruct.Mapper

@Mapper
interface GeocodingMapper : CleanCodeMapper<LocationDto, LocationEntity, Location>
