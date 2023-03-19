package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SearchInputValidator @Inject constructor() {

  private companion object {

    /**
     * Regular expression to validate city name.
     * It allows to use alpha
     */
    private const val PATTERN = "^\\p{Lu}\\p{L}*(?:[\\s-]\\p{Lu}\\p{L}*)*\$"
  }

  /**
   * Validates given [input] using a regular expression pattern to
   * prevent from API calls against unlikely location names.
   */
  fun test(input: String): Boolean =
    input.matches(Regex(PATTERN))
}
