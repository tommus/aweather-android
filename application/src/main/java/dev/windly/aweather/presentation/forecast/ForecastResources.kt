package dev.windly.aweather.presentation.forecast

import android.content.Context
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.windly.aweather.resources.R
import dev.windly.aweather.time.DateTimeFormat
import dev.windly.aweather.weather.domain.model.CurrentWeather
import dev.windly.aweather.weather.utility.CalculateDewPoint
import javax.inject.Inject
import kotlin.math.ceil
import kotlin.math.roundToInt

/**
 * Warning: As underestimating wind speed, rainfall or snowfall
 * intensity might be dangerous, the respective values were <b>rounded up</b>
 * to the next integer instead of approximating to the closest integer.
 */
@Reusable
class ForecastResources @Inject constructor(
  @ApplicationContext private val context: Context,
  private val calculateDewPoint: CalculateDewPoint,
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

    // API states the pressure is at a sea level.
    //
    // It would make more sense for the user to show a pressure on a
    // ground level - but it seems API fails to deliver this information,
    // even though it is documented.

    val pressure = forecast.main.pressure

    return context.getString(R.string.hpa, pressure)
  }

  /**
   * Returns a text representation of a wind speed.
   */
  fun windSpeed(forecast: CurrentWeather): CharSequence {

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

  /**
   * Returns a text representation of feels like temperature.
   */
  fun feelsLike(forecast: CurrentWeather): CharSequence {

    val rounded = forecast.main.feelsLike.roundToInt()

    return context.getString(R.string.degree, rounded)
  }

  /**
   * Returns a text representation of humidity.
   */
  fun humidity(forecast: CurrentWeather): CharSequence {

    val humidity = forecast.main.humidity

    return context.getString(R.string.humidity_percentage, humidity)
  }

  /**
   * Returns a text representation of calculated dew point.
   */
  fun dewPoint(forecast: CurrentWeather): CharSequence {

    val temperature = forecast.main.temperature
    val humidity = forecast.main.humidity
    val dewPoint = calculateDewPoint(temperature, humidity)

    return context.getString(R.string.dew_point_at, dewPoint)
  }

  /**
   * Returns a text representation of rainfall.
   */
  fun rain(forecast: CurrentWeather): CharSequence {

    val amount = ceil(forecast.rain?.threeHours ?: 0.0f).roundToInt()

    return context.getString(R.string.rain_amount, amount)
  }

  /**
   * Returns a text representation of snowfall.
   */
  fun snow(forecast: CurrentWeather): CharSequence {

    val amount = ceil(forecast.snow?.threeHours ?: 0.0f).roundToInt()

    return context.getString(R.string.snow_amount, amount)
  }

  private fun kph(): CharSequence = context.getString(R.string.kph)
  private fun mph(): CharSequence = context.getString(R.string.mph)
}
