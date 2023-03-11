package dev.windly.aweather.configuration

import dagger.Reusable
import dev.windly.aweather.configuration.BuildConfig
import javax.inject.Inject

@Reusable
class Configuration @Inject constructor() {

  fun isDebug(): Boolean = BuildConfig.DEBUG

  fun serverUrl(): String =
    BuildConfig.URL
}
