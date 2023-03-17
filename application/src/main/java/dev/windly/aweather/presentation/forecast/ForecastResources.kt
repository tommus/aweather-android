package dev.windly.aweather.presentation.forecast

import android.content.Context
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.windly.aweather.resources.R
import dev.windly.aweather.time.DateTimeFormat
import dev.windly.aweather.weather.domain.model.CurrentWeather
import javax.inject.Inject
import kotlin.math.ceil
import kotlin.math.roundToInt

@Reusable
class ForecastResources @Inject constructor(
  @ApplicationContext private val context: Context,
  private val format: DateTimeFormat,
) {

  /**
   * Returns a text representation of a temperature.
   */
  fun temperature(forecast: CurrentWeather): CharSequence {

    // Typical client does not need decimal precision so the value can
    // be rounded to the closest integer.

    val rounded = forecast.main.temperature.roundToInt()

    return context.getString(R.string.degree, rounded)
  }

  /**
   * Returns a text representation describing min-to-max range of
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

  /**
   * Returns a text representation describing a sunrise time.
   */
  fun sunrise(forecast: CurrentWeather): CharSequence =
    format.timeAsText(forecast.system.sunrise)

  /**
   * Returns a text representation describing a sunset time.
   */
  fun sunset(forecast: CurrentWeather): CharSequence {

    val sunset = forecast.system.sunset
    val text = format.timeAsText(sunset)

    return context.getString(R.string.sunset, text)
  }

  /**
   * Returns a text representation of an atmospheric pressure.
   */
  fun pressure(forecast: CurrentWeather): CharSequence {

    val pressure = forecast.main.pressure

    return context.getString(R.string.hpa, pressure)
  }

  /**
   * Returns a text representation of a wind speed.
   */
  fun windSpeed(forecast: CurrentWeather): CharSequence {

    // Underestimating a wind speed can be dangerous.
    //
    // That's why, instead of rounding to the closest integer, the
    // speed value was rounded up instead.

    val speed = ceil(forecast.wind.speed).roundToInt()

    // TODO: 17.03.2023
    //  API is parametrized by measurement units so the text format
    //  should be translated accordingly to the unit of choice.

    val unit = kph()

    return context.getString(R.string.wind_speed, speed, unit)
  }

  /**
   * Returns a text representation of gusts details.
   */
  fun gusts(forecast: CurrentWeather): CharSequence {

    val speed = ceil(forecast.wind.gust).roundToInt()
    val unit = kph()

    return context.getString(R.string.in_gusts_to, speed, unit)
  }

  /**
   * Returns a text representation of visibility details.
   */
  fun visibility(forecast: CurrentWeather): CharSequence {

    // Weirdly, API does not take into account imperial values for
    // the visibility.

    val distance = forecast.visibility / 1_000L

    return context.getString(R.string.visibility_distance, distance)
  }

  private fun kph(): CharSequence = context.getString(R.string.kph)
  private fun mph(): CharSequence = context.getString(R.string.mph)
}
