package dev.windly.aweather.presentation.forecast

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.forecast.ForecastFragmentDirections.Companion.actionSearch
import dev.windly.aweather.presentation.search.SearchFragment
import javax.inject.Inject

@FragmentScoped
class ForecastNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  /**
   * Navigates to the [SearchFragment].
   */
  fun navigateToFindLocation() {
    navController.navigate(actionSearch())
  }
}
