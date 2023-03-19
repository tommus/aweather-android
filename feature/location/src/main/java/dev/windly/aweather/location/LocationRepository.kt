package dev.windly.aweather.location

import dev.windly.aweather.location.domain.model.Location
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with a location module.
 */
interface LocationRepository {

  /**
   * Downloads all the [Location]s that also matches the
   * [SearchLocationCriteria].
   */
  fun download(criteria: SearchLocationCriteria): Completable

  /**
   * Observes all recently retrieved [Location]s.
   */
  fun observe(): Flowable<List<Location>>
}
