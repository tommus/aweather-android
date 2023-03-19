package dev.windly.aweather.recent

import dev.windly.aweather.recent.domain.model.Recent
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with a recent module.
 */
interface RecentRepository {

  /**
   * Saves [Recent] search so later on it might be served as
   * a hint for commonly used locations.
   */
  fun persist(recent: Recent): Completable

  /**
   * Observes last five [Recent]s that also matches the
   * [SearchRecentCriteria].
   */
  fun observeLastFive(criteria: SearchRecentCriteria): Flowable<List<Recent>>
}
