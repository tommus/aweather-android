package dev.windly.aweather.recent

/**
 * Immutable wrapper holding all the required details to retrieve
 * a recent location that matches the search input.
 */
data class SearchRecentCriteria(
  val input: String,
) {

  companion object {

    /**
     * Default representation of the [SearchRecentCriteria].
     */
    val Default = SearchRecentCriteria(input = "")
  }

  /**
   * Returns <code>true</code> for blank [input].
   */
  fun isBlankInput(): Boolean = input.isBlank()
}
