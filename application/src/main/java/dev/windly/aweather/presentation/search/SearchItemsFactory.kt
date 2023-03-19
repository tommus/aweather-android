package dev.windly.aweather.presentation.search

import com.mikepenz.fastadapter.GenericItem
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent
import dev.windly.aweather.presentation.search.recent.RecentHeaderItem
import dev.windly.aweather.presentation.search.recent.RecentItem
import dev.windly.aweather.presentation.search.result.SearchHeaderItem
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

    val recentHeader = createRecentHeaderItem()
    val recent = state.recent.map(::createRecentItem)

    val foundHeader = createSearchHeaderItem()
    val found = state.results.map(::createSearchResultItem)

    val items = mutableListOf<GenericItem>()

    if (recent.isNotEmpty()) {
      items += recentHeader
      items += recent
    }

    // TODO: 19.03.2023 Empty placeholder.

    if (found.isNotEmpty()) {
      items += foundHeader
      items += found
    }

    return items
  }

  /**
   * Creates [RecentHeaderItem].
   */
  private fun createRecentHeaderItem(): GenericItem =
    RecentHeaderItem()

  /**
   * Creates [RecentItem] for the [Recent].
   */
  private fun createRecentItem(recent: Recent): GenericItem =
    RecentItem(recent)
      .withName(recent.name)

  /**
   * Creates [SearchHeaderItem].
   */
  private fun createSearchHeaderItem(): GenericItem =
    SearchHeaderItem()

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
