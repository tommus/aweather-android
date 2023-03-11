package dev.windly.aweather.android.log

import dev.windly.aweather.configuration.Configuration
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject

class ConfigureTimber @Inject constructor(
  private val configuration: Configuration,
  private val debug: DebugTree
) : Runnable {

  override fun run() {
    if (configuration.isDebug()) {
      Timber.plant(debug)
    }
  }
}
