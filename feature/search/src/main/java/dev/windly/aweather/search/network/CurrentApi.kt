package dev.windly.aweather.search.network

import dev.windly.aweather.search.network.model.CurrentWeatherDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Negotiate API documentation for more details.
 *
 * @see <a href="https://openweathermap.org/current">Current API</a>
 */
interface CurrentApi {

  /**
   * Retrieves current weather data for any location on Earth.
   *
   * @param latitude geographical coordinates (latitude)
   * @param longitude geographical coordinates (longitude)
   * @param units units of measurement
   * @param appId unique API key
   */
  @GET("data/2.5/weather")
  fun getCurrentWeatherData(
    @Query("lat") latitude: Double,
    @Query("long") longitude: Double,
    @Query("units") units: String,
    @Query("appId") appId: String,
  ): Single<CurrentWeatherDto>
}
