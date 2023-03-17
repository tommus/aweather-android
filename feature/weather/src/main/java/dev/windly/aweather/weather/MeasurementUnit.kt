package dev.windly.aweather.weather

import androidx.annotation.StringDef
import dev.windly.aweather.weather.MeasurementUnit.Companion.IMPERIAL
import dev.windly.aweather.weather.MeasurementUnit.Companion.METRIC
import dev.windly.aweather.weather.MeasurementUnit.Companion.STANDARD

/**
 * Allows to request measurements in a specific unit.
 *
 * @see <a href="https://openweathermap.org/current#data">Units of measurement</a>
 */
@Retention(value = AnnotationRetention.SOURCE)
@StringDef(value = [STANDARD, METRIC, IMPERIAL])
annotation class MeasurementUnit {

  companion object {

    /**
     * Configures API to return:
     * - temperature in <b>Kelvin</b>.
     */
    const val STANDARD = "standard"

    /**
     * Configures API to return:
     * - temperature in <b>Celsius</b>.
     */
    const val METRIC = "metric"

    /**
     * Configures API to return:
     * - temperature in <b>Fahrenheit</b>.
     */
    const val IMPERIAL = "imperial"
  }
}
