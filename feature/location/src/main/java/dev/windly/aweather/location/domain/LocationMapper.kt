package dev.windly.aweather.location.domain

import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.location.network.model.LocationDto
import dev.windly.aweather.location.persistence.model.LocationEntity
import dev.windly.limbo.mapstruct.CleanCodeMapper
import org.mapstruct.Mapper

@Mapper
interface LocationMapper : CleanCodeMapper<LocationDto, LocationEntity, Location>
