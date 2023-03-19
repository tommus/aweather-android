package dev.windly.aweather.presentation.forecast

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.weather.TrimmedCoordinates
import dev.windly.aweather.weather.WeatherRepository
import dev.windly.aweather.weather.domain.model.CurrentWeather
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

@ViewModelScoped
class ForecastWeather @Inject constructor(
  private val coordinates: TrimmedCoordinates,
  private val repository: WeatherRepository,
) {

  /**
   * Provides a stream that loads a [CurrentWeather] details from a cache
   * by using a trimmed coordinates.
   */
  fun observe(): Flowable<CurrentWeather> =
    coordinates.observeAsCriteria()
      .flatMap(repository::observeWeather)
}
