package dev.windly.aweather.search

import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with the search module.
 */
interface SearchRepository {

  // TODO: 13.03.2023 Use more specific return type.

  /**
   * Searches for all the locations that also matches the [SearchCriteria].
   */
  fun execute(criteria: SearchCriteria): Flowable<List<Any>>
}
