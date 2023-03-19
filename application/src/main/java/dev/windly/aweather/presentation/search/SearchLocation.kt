package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.location.LocationRepository
import dev.windly.aweather.location.SearchLocationCriteria
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.recent.RecentRepository
import dev.windly.aweather.recent.SearchRecentCriteria
import dev.windly.aweather.recent.domain.model.Recent
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

@ViewModelScoped
class SearchLocation @Inject constructor(
  private val location: LocationRepository,
  private val recent: RecentRepository,
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
   * Emits new [SearchLocationCriteria] whenever condition changes.
   */
  private fun locationCriteria(): Flowable<SearchLocationCriteria> =
    input.map(::SearchLocationCriteria).debounce(DELAY, MILLISECONDS)

  /**
   * Searches for the locations that matches the search criteria.
   */
  private fun searchLocations(criteria: SearchLocationCriteria): Flowable<List<Location>> =
    location.download(criteria)
      .andThen(location.observe())

  /**
   * Searches for all the results that matches the search criteria.
   */
  private fun locations(): Flowable<List<Location>> =
    locationCriteria().switchMap(::searchLocations)

  private fun recentCriteria(): Flowable<SearchRecentCriteria> =
    input.map(::SearchRecentCriteria).debounce(DELAY, MILLISECONDS)

  /**
   * Searches for the recent locations that matches the search criteria.
   */
  private fun searchRecent(criteria: SearchRecentCriteria): Flowable<List<Recent>> =
    recent.observeLastFive(criteria)

  /**
   * Searches for the last five recent locations that matches the
   * search input.
   */
  private fun recent(): Flowable<List<Recent>> =
    recentCriteria().switchMap(::searchRecent)

  /**
   * Emits a filtered [SearchResults] for the provided [SearchLocationCriteria].
   */
  fun results(): Flowable<SearchResults> =
    Flowable
      .combineLatest(locationCriteria(), locations(), recent(), ::SearchResults)
      .subscribeOn(Schedulers.computation())
}
