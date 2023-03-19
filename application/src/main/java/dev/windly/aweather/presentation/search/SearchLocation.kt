package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.geocoding.GeocodingRepository
import dev.windly.aweather.geocoding.SearchCriteria
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

@ViewModelScoped
class SearchLocation @Inject constructor(
  private val search: GeocodingRepository
) {

  private companion object {

    /**
     * Adds a slight delay between actions so the search won't
     * be queried too often.
     */
    private const val DELAY = 300L /* ms */

    /**
     * Initially, search field is empty.
     */
    private const val QUERY = ""
  }

  private val input: FlowableProcessor<String> =
    BehaviorProcessor.createDefault(QUERY)

  /**
   * Accepts new search input [value].
   */
  fun onInput(value: String) {
    input.onNext(value)
  }

  /**
   * Emits a raw [input] whenever user decides to change it.
   */
  fun input(): Flowable<String> =
    input.hide()

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
      .andThen(search.observeLocations())

  /**
   * Searches for all the results that matches the search criteria.
   */
  private fun locations(): Flowable<List<Location>> =
    criteria().switchMap(::searchLocations)

  /**
   * Searches for the recent locations that matches the search criteria.
   */
  private fun searchRecent(criteria: SearchCriteria): Flowable<List<Recent>> =
    search.observeLastFiveRecent(criteria)

  /**
   * Searches for the last five recent locations that matches the
   * search input.
   */
  private fun recent(): Flowable<List<Recent>> =
    criteria().switchMap(::searchRecent)

  /**
   * Emits a filtered [SearchResults] for the provided [SearchCriteria].
   */
  fun results(): Flowable<SearchResults> =
    Flowable
      .combineLatest(criteria(), locations(), recent(), ::SearchResults)
      .subscribeOn(Schedulers.computation())
}
