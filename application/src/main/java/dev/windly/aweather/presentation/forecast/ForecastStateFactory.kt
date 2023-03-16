package dev.windly.aweather.presentation.forecast

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.weather.domain.model.CurrentWeather
import javax.inject.Inject

@ViewModelScoped
class ForecastStateFactory @Inject constructor(
  private val resources: ForecastResources
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
      loading = loading,
    )

  private fun temperatureFor(forecast: CurrentWeather): CharSequence =
    resources.temperature(forecast)

  private fun descriptionFor(forecast: CurrentWeather): CharSequence =
    "to be implemented".replaceFirstChar { it.uppercase() }

  private fun rangeFor(forecast: CurrentWeather): CharSequence =
    resources.range(forecast)
}
