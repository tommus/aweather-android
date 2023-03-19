package dev.windly.aweather.presentation.search

import android.content.Context
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.windly.aweather.resources.R
import javax.inject.Inject

@Reusable
class SearchResources @Inject constructor(
  @ApplicationContext private val context: Context,
) {

  /**
   * Returns an encouraging text to highlight the fact the
   * search input is empty.
   */
  fun enterSomething(): CharSequence =
    context.getString(R.string.enter_something)

  /**
   * Returns an information mentioning no results was found.
   */
  fun noResults(): CharSequence =
    context.getString(R.string.no_results_found)

  /**
   * Returns a details placeholder that can be used in case if no
   * location details are available.
   */
  fun placeholder(): CharSequence =
    context.getString(R.string.placeholder)

  /**
   * Returns an information mentioning the validation error occurred.
   */
  fun validationError(): CharSequence =
    context.getString(R.string.validation_error)
}
