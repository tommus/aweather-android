package dev.windly.aweather.presentation.search

import dev.windly.aweather.geocoding.SearchCriteria
import dev.windly.aweather.geocoding.domain.model.Location

/**
 * Immutable data holder for the search results.
 *
 * Additionally it contains [SearchCriteria] so it's possible
 * for example to highlight the original search phrase.
 */
data class SearchResults(
  val criteria: SearchCriteria,
  val locations: List<Location>,
) {

  companion object {

    /**
     * Empty search results.
     */
    val Empty = SearchResults(
      criteria = SearchCriteria.Default,
      locations = emptyList(),
    )
  }
}
