package dev.windly.aweather.recent.domain

import dev.windly.aweather.recent.domain.model.Recent
import dev.windly.aweather.recent.persistence.model.RecentEntity
import dev.windly.limbo.mapstruct.EntityToModelMapper
import org.mapstruct.Mapper

@Mapper
interface RecentMapper : EntityToModelMapper<RecentEntity, Recent>
