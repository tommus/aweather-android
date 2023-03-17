package dev.windly.aweather.weather.network

import dev.windly.aweather.weather.MeasurementLang
import dev.windly.aweather.weather.MeasurementUnit
import dev.windly.aweather.weather.network.model.CurrentWeatherDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Negotiate API documentation for more details.
 *
 * @see <a href="https://openweathermap.org/current">Current API</a>
 */
interface CurrentWeatherApi {

  /**
   * Retrieves a current weather data for any location on Earth.
   *
   * @param latitude geographical coordinates (latitude)
   * @param longitude geographical coordinates (longitude)
   * @param units units of measurement
   * @param appId unique API key
   */
  @GET("data/2.5/weather")
  fun getCurrentWeather(
    @Query("lat") latitude: Float,
    @Query("lon") longitude: Float,
    @Query("lang") @MeasurementLang language: String,
    @Query("units") @MeasurementUnit units: String,
    @Query("appId") appId: String,
  ): Single<CurrentWeatherDto>
}
