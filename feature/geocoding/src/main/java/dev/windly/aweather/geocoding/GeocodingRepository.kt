package dev.windly.aweather.geocoding

import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent
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
   * Observes all recently retrieved [Location]s.
   */
  fun observeLocations(): Flowable<List<Location>>

  /**
   * Saves [Recent] search so later on it might be served as
   * a hint for commonly used locations.
   */
  fun saveRecent(recent: Recent): Completable

  /**
   * Observes last five [Recent]s that also matches the
   * [SearchCriteria].
   */
  fun observeLastFiveRecent(criteria: SearchCriteria): Flowable<List<Recent>>
}
