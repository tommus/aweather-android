package dev.windly.aweather.geocoding

/**
 * Immutable wrapper holding all the required details to retrieve
 * a geolocation of the location specified as a search input.
 */
data class SearchCriteria(
  val input: String,
  val limit: Int? = null
) {

  companion object {

    /**
     * Default representation of the [SearchCriteria].
     */
    val Default = SearchCriteria(
      input = "",
      limit = null,
    )
  }
}
