package dev.windly.aweather.geocoding.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.geocoding.GeocodingRepository
import dev.windly.aweather.geocoding.SearchCriteria
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.network.GeocodingApi
import dev.windly.aweather.geocoding.persistence.LocationDao
import dev.windly.aweather.geocoding.persistence.model.LocationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GeocodingDomainRepository @Inject constructor(
  private val api: GeocodingApi,
  private val configuration: Configuration,
  private val dao: LocationDao,
  private val mapper: GeocodingMapper
) : GeocodingRepository {

  override fun downloadLocations(criteria: SearchCriteria): Completable =
    api
      .getCoordinatesByLocationName(
        query = criteria.input,
        limit = criteria.limit,
        appId = configuration.openWeatherAppId(),
      )
      .onErrorReturn { emptyList() }
      .map(mapper::mapDtoListToEntityList)
      .flatMapCompletable(::replaceLocations)
      .subscribeOn(Schedulers.io())

  private fun replaceLocations(entities: List<LocationEntity>): Completable =
    Completable
      .concatArray(clearLocations(), insertLocations(entities))
      .subscribeOn(Schedulers.io())

  private fun clearLocations(): Completable =
    dao.deleteAll()

  private fun insertLocations(entities: List<LocationEntity>): Completable =
    Completable
      .fromAction { dao.insert(entities) }
      .subscribeOn(Schedulers.io())

  override fun observeLocations(): Flowable<List<Location>> =
    dao
      .observeLocations()
      .map(mapper::mapEntityListToDomainList)
      .subscribeOn(Schedulers.io())
}
