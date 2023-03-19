package dev.windly.aweather.recent.domain

import dev.windly.aweather.recent.RecentRepository
import dev.windly.aweather.recent.SearchRecentCriteria
import dev.windly.aweather.recent.domain.model.Recent
import dev.windly.aweather.recent.persistence.RecentDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RecentDomainRepository @Inject constructor(
  private val dao: RecentDao,
  private val mapper: RecentMapper,
) : RecentRepository {

  override fun persist(recent: Recent): Completable =
    Completable
      .fromAction { dao.insert(mapper.mapDomainToEntity(recent)) }
      .subscribeOn(Schedulers.io())

  override fun observeLastFive(
    criteria: SearchRecentCriteria
  ): Flowable<List<Recent>> =
    when (criteria.isBlankInput()) {
      true -> noRecentLocations()
      false -> lastRecentLocations(criteria)
    }.subscribeOn(Schedulers.io())

  private fun lastRecentLocations(
    criteria: SearchRecentCriteria
  ): Flowable<List<Recent>> =
    dao.observeLastFive(criteria.input)
      .map(mapper::mapEntityListToDomainList)

  private fun noRecentLocations(): Flowable<List<Recent>> =
    Flowable.just(emptyList())
}
