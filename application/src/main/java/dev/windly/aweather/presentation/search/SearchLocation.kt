package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.FragmentScoped
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

@FragmentScoped
class SearchLocation @Inject constructor() {

  private companion object {

    /**
     * Adds a slight delay between actions so the search won't
     * be queried too often.
     */
    private const val DELAY = 100L /* ms */
  }

  /**
   * Immutable data holder for the search criteria.
   */
  data class SearchCriteria(
    val input: String
  )

  /**
   * Immutable data holder for the search results.
   *
   * Additionally it contains [SearchCriteria] so it's possible
   * for example to highlight the original search phrase.
   */
  data class SearchResults(
    val criteria: SearchCriteria
  )

  private val input: FlowableProcessor<String> =
    BehaviorProcessor.createDefault("")

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

  // TODO: 12.03.2023 Implement saerch method returning search results.

  // TODO: 12.03.2023 Combine search criteria with results.

  /**
   * Emits a filtered [SearchResults] for the provided [SearchCriteria].
   */
  fun results(): Flowable<SearchResults> =
    criteria().map(::SearchResults)
      .subscribeOn(Schedulers.computation())
}
