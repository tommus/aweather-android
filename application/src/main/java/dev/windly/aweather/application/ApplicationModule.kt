package dev.windly.aweather.application

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class ApplicationModule {

  @[Provides Singleton]
  internal fun resources(@ApplicationContext context: Context): Resources =
    context.resources
}
