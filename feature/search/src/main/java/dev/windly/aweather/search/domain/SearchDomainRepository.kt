package dev.windly.aweather.search.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.search.SearchCriteria
import dev.windly.aweather.search.SearchRepository
import dev.windly.aweather.search.domain.model.Location
import dev.windly.aweather.search.network.GeocodingApi
import dev.windly.aweather.search.persistence.LocationDao
import dev.windly.aweather.search.persistence.model.LocationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchDomainRepository @Inject constructor(
  private val api: GeocodingApi,
  private val configuration: Configuration,
  private val dao: LocationDao,
  private val mapper: SearchMapper
) : SearchRepository {

  override fun downloadLocations(criteria: SearchCriteria): Completable =
    api
      .getCoordinatesByLocationName(
        query = criteria.input,
        limit = criteria.limit,
        appId = configuration.openWeatherAppId(),
      )
      .map(mapper::mapDtoListToEntityList)
      .flatMapCompletable(::saveLocations)
      .subscribeOn(Schedulers.io())

  private fun saveLocations(entities: List<LocationEntity>): Completable =
    Completable
      .fromAction { dao.insert(entities) }
      .subscribeOn(Schedulers.io())

  override fun observeLocations(criteria: SearchCriteria): Flowable<List<Location>> =
    when (criteria.limit) {
      null -> dao.observeLocations(query = criteria.input)
      else -> dao.observeLocations(query = criteria.input, limit = criteria.limit)
    }
      .map(mapper::mapEntityListToDomainList)
      .subscribeOn(Schedulers.io())
}
