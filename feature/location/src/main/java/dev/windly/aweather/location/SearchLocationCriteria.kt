package dev.windly.aweather.location

/**
 * Immutable wrapper holding all the required details to retrieve
 * a geolocation of the location specified as a search input.
 */
data class SearchLocationCriteria(
  val input: String,
  val limit: Int? = DEFAULT_LIMIT
) {

  companion object {

    /**
     * A number of results that will be returned for the
     * matching [SearchLocationCriteria].
     */
    private const val DEFAULT_LIMIT = 100

    /**
     * Default representation of the [SearchLocationCriteria].
     */
    val Default = SearchLocationCriteria(
      input = "",
      limit = DEFAULT_LIMIT,
    )
  }

  /**
   * Returns <code>true</code> for blank [input].
   */
  fun isBlankInput(): Boolean = input.isBlank()
}
