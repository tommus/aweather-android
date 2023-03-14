package dev.windly.aweather.configuration

import dagger.Reusable
import javax.inject.Inject

@Reusable
class Configuration @Inject constructor() {

  fun isDebug(): Boolean = BuildConfig.DEBUG

  fun openWeatherApiUrl(): String =
    BuildConfig.OPEN_WEATHER_API_URL

  fun openWeatherAppId(): String =
    BuildConfig.OPEN_WEATHER_APP_ID
}
