package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.windly.aweather.geocoding.GeocodingRepository
import dev.windly.aweather.geocoding.SearchCriteria
import dev.windly.aweather.geocoding.domain.model.Location
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

@ActivityRetainedScoped
class SearchLocation @Inject constructor(
  private val search: GeocodingRepository
) {

  private companion object {

    /**
     * Adds a slight delay between actions so the search won't
     * be queried too often.
     */
    private const val DELAY = 100L /* ms */

    /**
     * Initially, search field is empty.
     */
    private const val QUERY = ""
  }

  /**
   * Immutable data holder for the search results.
   *
   * Additionally it contains [SearchCriteria] so it's possible
   * for example to highlight the original search phrase.
   */
  data class SearchResults(
    val criteria: SearchCriteria,
    val locations: List<Location>,
  )

  private val input: FlowableProcessor<String> =
    BehaviorProcessor.createDefault(QUERY)

  /**
   * Accepts new search input [value].
   */
  fun onInput(value: String) {
    input.onNext(value)
  }

  /**
   * Emits new [SearchCriteria] whenever condition changes.
   */
  private fun criteria(): Flowable<SearchCriteria> =
    input.map(::SearchCriteria).debounce(DELAY, MILLISECONDS)

  /**
   * Searches for the locations that matches the search criteria.
   */
  private fun searchLocations(criteria: SearchCriteria): Flowable<List<Location>> =
    search.downloadLocations(criteria)
      .andThen(search.observeLocations(criteria))

  /**
   * Searches for all the results that matches the search criteria.
   */
  private fun locations(): Flowable<List<Location>> =
    criteria().switchMap(::searchLocations)

  /**
   * Emits a filtered [SearchResults] for the provided [SearchCriteria].
   */
  fun results(): Flowable<SearchResults> =
    Flowable
      .combineLatest(criteria(), locations(), ::SearchResults)
      .subscribeOn(Schedulers.computation())
}
