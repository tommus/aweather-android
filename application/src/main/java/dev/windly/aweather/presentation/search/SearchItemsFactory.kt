package dev.windly.aweather.presentation.search

import com.mikepenz.fastadapter.GenericItem
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.presentation.search.recent.RecentHeaderItem
import dev.windly.aweather.presentation.search.recent.RecentItem
import dev.windly.aweather.presentation.search.result.SearchResultItem
import javax.inject.Inject

@FragmentScoped
class SearchItemsFactory @Inject constructor(
  private val resources: SearchResources,
) {

  /**
   * Creates all the items that all together composes into a
   * [SearchFragment] content.
   */
  fun create(state: SearchState): List<GenericItem> {

    val header = createRecentHeaderItem()
    val history = state.history.map(::createRecentItem)
    val found = state.results.map(::createSearchResultItem)

    val items = mutableListOf<GenericItem>()

    if (history.isNotEmpty()) {
      items += header
      items += history
    }

    // TODO: 19.03.2023 Empty placeholder.
    items += found

    return items
  }

  /**
   * Creates [RecentHeaderItem].
   */
  private fun createRecentHeaderItem(): GenericItem =
    RecentHeaderItem()

  /**
   * Creates [RecentItem] for the [Location].
   */
  private fun createRecentItem(location: Location): GenericItem =
    RecentItem(location)
      .withName(location.name)

  /**
   * Creates [SearchResultItem] for the [Location].
   */
  private fun createSearchResultItem(location: Location): GenericItem =
    SearchResultItem(location)
      .withName(location.name)
      .withDetails(detailsFor(location))

  /**
   * Extracts location details for the given [Location].
   */
  private fun detailsFor(location: Location): CharSequence {

    val country = location.country
    val state = location.state.orEmpty()

    if (country.isNotBlank() && state.isNotBlank()) {
      return "%s, %s".format(country, state)
    }

    if (country.isNotBlank()) {
      return country
    }

    return resources.placeholder()
  }
}
