package dev.windly.aweather.presentation.forecast

import android.graphics.drawable.Drawable
import dagger.Reusable
import dev.windly.aweather.resources.WeatherIconResources
import javax.inject.Inject

@Reusable
class ForecastIcons @Inject constructor(
  private val resources: WeatherIconResources
) {

  /**
   * Provides an image that showcases the weather coded behind
   * the hash string.
   */
  fun require(code: String): Drawable =
    when (code) {
      "01d" -> resources.clearSkyDay()
      "01n" -> resources.clearSkyNight()
      "02d" -> resources.fewCloudsDay()
      "02n" -> resources.fewCloudsNight()
      "03d" -> resources.scatteredClouds()
      "03n" -> resources.scatteredClouds()
      "04d" -> resources.brokenClouds()
      "04n" -> resources.brokenClouds()
      "09d" -> resources.showerRainDay()
      "09n" -> resources.showerRainNight()
      "10d" -> resources.rainDay()
      "10n" -> resources.rainNight()
      "11d" -> resources.thunderstormDay()
      "11n" -> resources.thunderstormNight()
      "13d" -> resources.snowDay()
      "13n" -> resources.snowNight()
      "50d" -> resources.mistDay()
      "50n" -> resources.mistNight()
      else -> throw IllegalStateException("Undefined weather code.")
    }
}
