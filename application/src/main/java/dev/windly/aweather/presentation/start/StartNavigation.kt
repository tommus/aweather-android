package dev.windly.aweather.presentation.start

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.start.StartFragmentDirections.Companion.actionFresh
import dev.windly.aweather.presentation.start.StartFragmentDirections.Companion.actionVisited
import javax.inject.Inject

@FragmentScoped
class StartNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  /**
   * Navigates to the fresh start flow.
   */
  fun navigateToFresh() {
    navController.navigate(actionFresh())
  }

  /**
   * Navigates to the previously visited flow.
   */
  fun navigateToVisited(latitude: Double, longitude: Double) {

    val action = actionVisited(
      latitude = latitude.toFloat(),
      longitude = longitude.toFloat(),
    )

    navController.navigate(action)
  }
}
