package dev.windly.aweather.base.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

abstract class BaseFragmentNavigation(protected val fragment: Fragment) {

  protected open val navController: NavController
    by lazy { fragment.findNavController() }

  /**
   * Attempts to navigate up in the navigation hierarchy.
   */
  open fun navigateUp() =
    navController.navigateUp()
}
