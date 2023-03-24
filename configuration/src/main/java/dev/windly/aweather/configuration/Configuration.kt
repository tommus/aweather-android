package dev.windly.aweather.configuration

import android.content.res.Resources
import android.os.Build
import dagger.Reusable
import java.util.Locale
import javax.inject.Inject

@Reusable
class Configuration @Inject constructor(
  private val resources: Resources,
) {

  fun isDebug(): Boolean = BuildConfig.DEBUG

  fun openWeatherApiUrl(): String =
    BuildConfig.OPEN_WEATHER_API_URL

  fun openWeatherAppId(): String =
    BuildConfig.OPEN_WEATHER_APP_ID

  /**
   * Provides a primary language default for the current
   * operating system configuration.
   */
  fun locale(): Locale =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      resources.configuration.locales[0]
    } else {
      resources.configuration.locale
    }
}
