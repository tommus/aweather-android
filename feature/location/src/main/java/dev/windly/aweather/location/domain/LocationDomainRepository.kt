package dev.windly.aweather.location.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.location.LocationRepository
import dev.windly.aweather.location.SearchLocationCriteria
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.location.network.LocationApi
import dev.windly.aweather.location.persistence.LocationDao
import dev.windly.aweather.location.persistence.model.LocationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class LocationDomainRepository @Inject constructor(
  private val api: LocationApi,
  private val configuration: Configuration,
  private val dao: LocationDao,
  private val mapper: LocationMapper,
) : LocationRepository {

  override fun download(criteria: SearchLocationCriteria): Completable =
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

  override fun observe(): Flowable<List<Location>> =
    dao
      .observeLocations()
      .map(mapper::mapEntityListToDomainList)
      .subscribeOn(Schedulers.io())
}
