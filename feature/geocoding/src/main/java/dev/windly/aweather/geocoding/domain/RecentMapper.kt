package dev.windly.aweather.geocoding.domain

import dev.windly.aweather.geocoding.domain.model.Recent
import dev.windly.aweather.geocoding.persistence.model.RecentEntity
import dev.windly.limbo.mapstruct.EntityToModelMapper
import org.mapstruct.Mapper

@Mapper
interface RecentMapper : EntityToModelMapper<RecentEntity, Recent>
