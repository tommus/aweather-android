package dev.windly.aweather.presentation.search

import dev.windly.aweather.location.SearchLocationCriteria
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.recent.domain.model.Recent

/**
 * Immutable data holder for the search results.
 *
 * Additionally it contains [SearchLocationCriteria] so it's possible
 * for example to highlight the original search phrase.
 */
data class SearchResults(
  val criteria: SearchLocationCriteria,
  val valid: Boolean,
  val locations: List<Location>,
  val recent: List<Recent>,
) {

  companion object {

    /**
     * Empty search results.
     */
    val Empty = SearchResults(
      criteria = SearchLocationCriteria.Default,
      valid = false,
      locations = emptyList(),
      recent = emptyList(),
    )
  }
}
