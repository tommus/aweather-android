package dev.windly.aweather.presentation.search

import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent

data class SearchState(
  val input: String = "",
  val recent: List<Recent> = emptyList(),
  val results: List<Location> = emptyList(),
) {

  companion object {

    /**
     * Default representation of the [SearchState].
     */
    val Empty = SearchState()
  }
}
