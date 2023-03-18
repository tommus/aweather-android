package dev.windly.aweather.presentation.forecast

import android.graphics.drawable.Drawable
import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.weather.domain.model.CurrentWeather
import javax.inject.Inject

@ViewModelScoped
class ForecastStateFactory @Inject constructor(
  private val icons: ForecastIcons,
  private val resources: ForecastResources,
) {

  internal fun create(
    forecast: CurrentWeather,
    loading: Int,
  ): ForecastState =
    ForecastState(
      name = forecast.name,
      date = today(),
      temperature = temperatureFor(forecast),
      description = descriptionFor(forecast),
      icon = iconFor(forecast),
      range = rangeFor(forecast),
      sunrise = sunriseFor(forecast),
      sunset = sunsetFor(forecast),
      pressure = pressureFor(forecast),
      wind = windFor(forecast),
      gusts = gustsFor(forecast),
      visibility = visibilityFor(forecast),
      feelsLike = feelsLikeFor(forecast),
      humidity = humidityFor(forecast),
      dewPoint = dewPointFor(forecast),
      rain = rainFor(forecast),
      snow = snowFor(forecast),
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

  private fun windFor(forecast: CurrentWeather): CharSequence =
    resources.windSpeed(forecast)

  private fun gustsFor(forecast: CurrentWeather): CharSequence =
    resources.gusts(forecast)

  private fun visibilityFor(forecast: CurrentWeather): CharSequence =
    resources.visibility(forecast)

  private fun feelsLikeFor(forecast: CurrentWeather): CharSequence =
    resources.feelsLike(forecast)

  private fun humidityFor(forecast: CurrentWeather): CharSequence =
    resources.humidity(forecast)

  private fun dewPointFor(forecast: CurrentWeather): CharSequence =
    resources.dewPoint(forecast)

  private fun rainFor(forecast: CurrentWeather): CharSequence =
    resources.rain(forecast)

  private fun snowFor(forecast: CurrentWeather): CharSequence =
    resources.snow(forecast)

  private fun iconFor(forecast: CurrentWeather): Drawable? {

    val weather = forecast.weather.firstOrNull()
      ?: return null

    return icons.require(weather.icon)
  }

  private fun today(): CharSequence =
    resources.today()
}
