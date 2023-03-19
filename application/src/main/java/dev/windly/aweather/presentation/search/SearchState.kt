package dev.windly.aweather.presentation.search

import dev.windly.aweather.geocoding.domain.model.Location

data class SearchState(
  val input: String = "",
  val history: List<Location> = emptyList(),
  val results: List<Location> = emptyList(),
) {

  companion object {

    /**
     * Default representation of the [SearchState].
     */
    val Empty = SearchState()
  }
}
