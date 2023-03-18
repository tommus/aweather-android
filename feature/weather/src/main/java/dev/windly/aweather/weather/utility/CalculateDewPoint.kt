package dev.windly.aweather.weather.utility

import dagger.Reusable
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.roundToInt

@Reusable
class CalculateDewPoint @Inject constructor() {

  private companion object {

    /**
     * Constant value used for approximation of a dew point.
     */
    private const val DEW_CONST = 112

    /**
     * Fraction that effectively allows to use [pow] function
     * to calculate nth root of some value.
     */
    private const val HUMIDITY_ROOT = 1.0f / 8.0f
  }

  /**
   * Calculates an averaged dew point based on a measured
   * [temperature] and [humidity].
   *
   * Calculated value should be considered a simplified approximation
   * and be used for informational purposes only.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Dew_point">Dew point</a>
   */
  operator fun invoke(temperature: Float, humidity: Int): Int =
    precise(temperature, humidity).roundToInt()

  private fun precise(temperature: Float, humidity: Int): Float {

    val root = (humidity / 100.0f).pow(HUMIDITY_ROOT)
    val ax = DEW_CONST + 0.9f * temperature
    val bx = 0.1f * temperature

    return root * ax + bx - DEW_CONST
  }
}
