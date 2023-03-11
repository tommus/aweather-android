package dev.windly.aweather.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.windly.aweather.android.runtime.RunOnStartup
import javax.inject.Inject

@HiltAndroidApp
class AweatherApplication : Application() {

  @[Inject RunOnStartup]
  lateinit var tasks: Set<@JvmSuppressWildcards Runnable>

  override fun onCreate() {
    super.onCreate()

    // Tasks might be heavy.
    // Maybe it's worth to move them to background thread?
    tasks.forEach(Runnable::run)
  }
}
