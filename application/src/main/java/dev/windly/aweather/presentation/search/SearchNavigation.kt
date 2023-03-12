package dev.windly.aweather.presentation.search

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.forecast.ForecastFragment
import javax.inject.Inject

@FragmentScoped
class SearchNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  // TODO: 12.03.2023 Add navigation argument.

  /**
   * Navigates to the [ForecastFragment].
   */
  fun navigateToForecast() {
    // TODO: 12.03.2023 To be implemented.
  }
}
