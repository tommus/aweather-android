package dev.windly.aweather.weather

import dev.windly.aweather.weather.domain.model.CurrentWeather
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * An entry point for interacting with a weather module.
 */
interface WeatherRepository {

  /**
   * Downloads a weather forecast for the location defined in a
   * [SearchCriteria].
   */
  fun downloadForecast(criteria: SearchCriteria): Completable

  /**
   * Observes a weather forecast for the location defined in a
   * [SearchCriteria].
   */
  fun observeWeather(criteria: SearchCriteria): Flowable<CurrentWeather>
}
