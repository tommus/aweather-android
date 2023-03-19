package dev.windly.aweather.location.network

import dev.windly.aweather.location.network.model.LocationDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Negotiate API documentation for more details.
 *
 * @see <a href="https://openweathermap.org/api/geocoding-api">Geocoding API</a>
 */
interface LocationApi {

  /**
   * Retrieves geographical coordinates (lat, lon) by using name of the
   * location (city name or area name).
   *
   * @param query city name, state code (only for the US) and country code
   * divided by comma
   * @param limit number of the locations to retrieve
   * @param appId unique API key
   */
  @GET("geo/1.0/direct")
  fun getCoordinatesByLocationName(
    @Query("q") query: String,
    @Query("limit") limit: Int?,
    @Query("appId") appId: String,
  ): Single<List<LocationDto>>
}
