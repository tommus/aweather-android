package dev.windly.aweather.presentation

import android.app.Activity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@[Module InstallIn(ActivityComponent::class)]
class MainBuilder {

  @[Provides ActivityScoped]
  internal fun activity(activity: Activity): MainActivity =
    activity as MainActivity
}
