package dev.windly.aweather.presentation.forecast

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.weather.domain.model.CurrentWeather
import javax.inject.Inject

@ViewModelScoped
class ForecastStateFactory @Inject constructor(
  private val resources: ForecastResources,
) {

  internal fun create(
    forecast: CurrentWeather,
    loading: Int,
  ): ForecastState =
    ForecastState(
      name = forecast.name,
      temperature = temperatureFor(forecast),
      description = descriptionFor(forecast),
      range = rangeFor(forecast),
      sunrise = sunriseFor(forecast),
      sunset = sunsetFor(forecast),
      pressure = pressureFor(forecast),
      loading = loading,
    )

  private fun temperatureFor(forecast: CurrentWeather): CharSequence =
    resources.temperature(forecast)

  private fun descriptionFor(forecast: CurrentWeather): CharSequence {

    // API documentation is insufficient when it comes to the "weather"
    // content.
    //
    // It does not shed any additional light why it's a collection and
    // which description is the most relevant.
    //
    // Thus, I've decided to arbitrary pick the very first one.

    val weather = forecast.weather.firstOrNull()

    val description = weather?.description
      ?: resources.descriptionPlaceholder().toString()

    return description.replaceFirstChar { it.uppercase() }
  }

  private fun rangeFor(forecast: CurrentWeather): CharSequence =
    resources.range(forecast)

  private fun sunriseFor(forecast: CurrentWeather): CharSequence =
    resources.sunrise(forecast)

  private fun sunsetFor(forecast: CurrentWeather): CharSequence =
    resources.sunset(forecast)

  private fun pressureFor(forecast: CurrentWeather): CharSequence =
    resources.pressure(forecast)
}
