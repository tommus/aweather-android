package dev.windly.aweather.presentation.start

import androidx.fragment.app.Fragment
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.base.navigation.BaseFragmentNavigation
import javax.inject.Inject

@FragmentScoped
class StartNavigation @Inject constructor(fragment: Fragment) :
  BaseFragmentNavigation(fragment)
