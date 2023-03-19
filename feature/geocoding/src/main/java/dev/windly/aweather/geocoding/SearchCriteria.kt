package dev.windly.aweather.geocoding

/**
 * Immutable wrapper holding all the required details to retrieve
 * a geolocation of the location specified as a search input.
 */
data class SearchCriteria(
  val input: String,
  val limit: Int? = DEFAULT_LIMIT
) {

  companion object {

    /**
     * A number of results that will be returned for the
     * matching [SearchCriteria].
     */
    private const val DEFAULT_LIMIT = 100

    /**
     * Default representation of the [SearchCriteria].
     */
    val Default = SearchCriteria(
      input = "",
      limit = DEFAULT_LIMIT,
    )
  }
}
