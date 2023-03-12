package dev.windly.aweather.presentation.start

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import dev.windly.aweather.presentation.search.SearchFragment
import javax.inject.Inject

@FragmentScoped
class StartNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment) {

  /**
   * Navigates to the [SearchFragment].
   */
  fun navigateToSearch() {
    // TODO: 12.03.2023 To be implemented.
  }
}
