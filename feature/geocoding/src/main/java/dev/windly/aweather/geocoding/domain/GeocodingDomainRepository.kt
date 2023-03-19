package dev.windly.aweather.geocoding.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.geocoding.GeocodingRepository
import dev.windly.aweather.geocoding.SearchCriteria
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent
import dev.windly.aweather.geocoding.network.GeocodingApi
import dev.windly.aweather.geocoding.persistence.LocationDao
import dev.windly.aweather.geocoding.persistence.RecentDao
import dev.windly.aweather.geocoding.persistence.model.LocationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GeocodingDomainRepository @Inject constructor(
  private val api: GeocodingApi,
  private val configuration: Configuration,
  private val locationDao: LocationDao,
  private val geocodingMapper: GeocodingMapper,
  private val recentDao: RecentDao,
  private val recentMapper: RecentMapper,
) : GeocodingRepository {

  override fun downloadLocations(criteria: SearchCriteria): Completable =
    api
      .getCoordinatesByLocationName(
        query = criteria.input,
        limit = criteria.limit,
        appId = configuration.openWeatherAppId(),
      )
      .onErrorReturn { emptyList() }
      .map(geocodingMapper::mapDtoListToEntityList)
      .flatMapCompletable(::replaceLocations)
      .subscribeOn(Schedulers.io())

  private fun replaceLocations(entities: List<LocationEntity>): Completable =
    Completable
      .concatArray(clearLocations(), insertLocations(entities))
      .subscribeOn(Schedulers.io())

  private fun clearLocations(): Completable =
    locationDao.deleteAll()

  private fun insertLocations(entities: List<LocationEntity>): Completable =
    Completable
      .fromAction { locationDao.insert(entities) }
      .subscribeOn(Schedulers.io())

  override fun observeLocations(): Flowable<List<Location>> =
    locationDao
      .observeLocations()
      .map(geocodingMapper::mapEntityListToDomainList)
      .subscribeOn(Schedulers.io())

  // TODO: 19.03.2023 Extract recent into a separate repository.

  override fun saveRecent(recent: Recent): Completable =
    Completable
      .fromAction {
        recentMapper.mapDomainToEntity(recent)
          .let(recentDao::insert)
      }
      .subscribeOn(Schedulers.io())

  override fun observeLastFiveRecent(criteria: SearchCriteria): Flowable<List<Recent>> =
    when (criteria.isBlankInput()) {
      true -> noResultsForEmptyInput()
      false -> recentForInput(criteria)
    }.subscribeOn(Schedulers.io())

  private fun recentForInput(criteria: SearchCriteria): Flowable<List<Recent>> =
    recentDao.observeLastFive(criteria.input)
      .map(recentMapper::mapEntityListToDomainList)

  private fun noResultsForEmptyInput(): Flowable<List<Recent>> =
    Flowable.just(emptyList())
}
