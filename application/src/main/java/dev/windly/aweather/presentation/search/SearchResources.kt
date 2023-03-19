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
   * Returns a details placeholder that can be used in case if no
   * location details are available.
   */
  fun placeholder(): CharSequence =
    context.getString(R.string.placeholder)
}
