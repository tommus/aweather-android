package dev.windly.aweather.presentation.start

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.search.SearchFragment
import dev.windly.aweather.presentation.start.StartFragmentDirections.Companion.actionSearch
import javax.inject.Inject

@FragmentScoped
class StartNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  /**
   * Navigates to the [SearchFragment].
   */
  fun navigateToSearch() {
    navController.navigate(actionSearch())
  }
}
