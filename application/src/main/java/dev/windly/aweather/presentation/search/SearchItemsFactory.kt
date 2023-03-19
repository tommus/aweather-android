package dev.windly.aweather.presentation.search

import com.mikepenz.fastadapter.GenericItem
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.presentation.search.placeholder.PlaceholderItem
import dev.windly.aweather.presentation.search.recent.RecentHeaderItem
import dev.windly.aweather.presentation.search.recent.RecentItem
import dev.windly.aweather.presentation.search.result.SearchHeaderItem
import dev.windly.aweather.presentation.search.result.SearchResultItem
import dev.windly.aweather.recent.domain.model.Recent
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

    if (state.input.isBlank()) {
      return listOf(createPromptPlaceholder())
    }

    if (!state.valid) {
      return listOf(createValidationErrorPlaceholder())
    }

    val items = mutableListOf<GenericItem>()

    if (state.recent.isNotEmpty()) {
      items += createRecentHeaderItem()
      items += state.recent.map(::createRecentItem)
    }

    items += createSearchHeaderItem()

    when (state.results.isNotEmpty()) {
      true -> items += state.results.map(::createSearchResultItem)
      false -> items += createNoResultsPlaceholder()
    }

    return items
  }

  /**
   * Creates [PlaceholderItem] that encourages user to enter something
   * in a search field.
   */
  private fun createPromptPlaceholder(): GenericItem =
    PlaceholderItem()
      .withTitle(resources.enterSomething())

  /**
   * Creates [PlaceholderItem] that hints the user there is no results
   * matching his/her search criteria.
   */
  private fun createNoResultsPlaceholder(): GenericItem =
    PlaceholderItem()
      .withTitle(resources.noResults())

  /**
   * Creates [PlaceholderItem] that hints the user he/she entered the
   * incorrect search input.
   */
  private fun createValidationErrorPlaceholder(): GenericItem =
    PlaceholderItem()
      .withTitle(resources.validationError())

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
