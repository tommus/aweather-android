package dev.windly.aweather.search

/**
 * Immutable data holder for the search [input].
 */
data class SearchCriteria(
  val input: String,
  val limit: Int? = null
)
