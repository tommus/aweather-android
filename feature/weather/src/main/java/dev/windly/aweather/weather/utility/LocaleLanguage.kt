package dev.windly.aweather.weather.utility

import dagger.Reusable
import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.weather.MeasurementLang
import java.util.Locale
import javax.inject.Inject

@Reusable
class LocaleLanguage @Inject constructor(
  private val configuration: Configuration
) {

  private companion object {

    /**
     * ISO country code for Poland.
     */
    private const val POLAND = "pl-PL"
  }

  /**
   * Provides a [MeasurementLang] best suited for the operating system
   * configuration.
   */
  @MeasurementLang
  fun forMeasurements(): String =
    when (configuration.locale()) {
      poland() -> MeasurementLang.POLISH
      else -> MeasurementLang.ENGLISH
    }

  private fun poland(): Locale =
    Locale.forLanguageTag(POLAND)
}
