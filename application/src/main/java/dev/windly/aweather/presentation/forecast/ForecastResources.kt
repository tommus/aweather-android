package dev.windly.aweather.presentation.forecast

import android.content.Context
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.windly.aweather.resources.R
import dev.windly.aweather.weather.domain.model.CurrentWeather
import javax.inject.Inject
import kotlin.math.roundToInt

@Reusable
class ForecastResources @Inject constructor(
  @ApplicationContext private val context: Context
) {

  /**
   * Returns a string representation of a temperature.
   */
  fun temperature(forecast: CurrentWeather): CharSequence {

    // Typical client does not need decimal precision so the value can
    // be rounded to the closest integer.

    val rounded = forecast.main.temperature.roundToInt()

    return context.getString(R.string.degree, rounded)
  }

  /**
   * Returns a string representation describing min-to-max range of
   * temperatures.
   */
  fun range(forecast: CurrentWeather): CharSequence {

    val min = forecast.main.minimalTemperature.roundToInt()
    val max = forecast.main.maximalTemperature.roundToInt()

    return context.getString(R.string.range, min, max)
  }

  /**
   * Returns a placeholder that can be used in case of no additional forecast
   * description is provided by API.
   */
  fun descriptionPlaceholder(): CharSequence =
    context.getString(R.string.description_placeholder)
}
