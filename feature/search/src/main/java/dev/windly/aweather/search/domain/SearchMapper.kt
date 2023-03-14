package dev.windly.aweather.search.domain

import dev.windly.aweather.search.domain.model.Location
import dev.windly.aweather.search.network.model.LocationDto
import dev.windly.aweather.search.persistence.model.LocationEntity
import dev.windly.limbo.mapstruct.CleanCodeMapper
import org.mapstruct.Mapper

@Mapper
interface SearchMapper : CleanCodeMapper<LocationDto, LocationEntity, Location>
