package dev.windly.aweather.search.network

import dev.windly.aweather.search.network.model.LocationDto
import retrofit2.http.Query

/**
 * Negotiate API documentation for more details.
 *
 * @see <a href="https://openweathermap.org/api/geocoding-api">Geocoding API</a>
 */
interface GeocodingApi {

  fun getCoordinatesByLocationName(
    @Query("q") query: String,
    @Query("limit") limit: Int,
    @Query("AppId") appId: String,
  ): List<LocationDto>
}
