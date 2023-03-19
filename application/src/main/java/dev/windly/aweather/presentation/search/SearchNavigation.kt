package dev.windly.aweather.presentation.search

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.forecast.ForecastFragment
import dev.windly.aweather.presentation.search.SearchFragmentDirections.Companion.actionForecast
import javax.inject.Inject

@FragmentScoped
class SearchNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  /**
   * Navigates to the [ForecastFragment].
   */
  fun navigateToForecast(latitude: Double, longitude: Double) {

    val action = actionForecast(
      latitude = latitude.toFloat(),
      longitude = longitude.toFloat(),
    )

    navController.navigate(action)
  }
}
