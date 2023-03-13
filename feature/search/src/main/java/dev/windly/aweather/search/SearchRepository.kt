package dev.windly.aweather.search

import dev.windly.aweather.search.domain.model.Location
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with the search module.
 */
interface SearchRepository {

  /**
   * Downloads all the [Location]s that also matches the
   * [SearchCriteria].
   */
  fun downloadLocations(criteria: SearchCriteria): Completable

  /**
   * Observes all persisted [Location]s that also matches the
   * [SearchCriteria].
   */
  fun observeLocations(criteria: SearchCriteria): Flowable<List<Location>>
}
