package dev.windly.aweather.geocoding

import dev.windly.aweather.geocoding.domain.model.Location
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with a geocoding module.
 */
interface GeocodingRepository {

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
