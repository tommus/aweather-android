package dev.windly.aweather.presentation.search

data class SearchState(
  val input: String = ""
) {

  companion object {

    /**
     * Default representation of the [SearchState].
     */
    val Empty = SearchState()
  }
}
