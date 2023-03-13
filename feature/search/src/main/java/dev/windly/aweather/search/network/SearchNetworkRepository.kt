package dev.windly.aweather.search.network

import dev.windly.aweather.search.network.model.LocationDto
import javax.inject.Inject

class SearchNetworkRepository @Inject constructor(
  private val api: GeocodingApi
) {

  /**
   * Retrieves geographical coordinates (lat, lon) by using name of the
   * location (city name or area name).
   *
   * @param query city name, state code (only for the US) and country code
   * divided by comma
   * @param limit number of the locations to retrieve
   * @param appId unique API key
   */
  fun getCoordinatesByLocation(
    query: String, limit: Int, appId: String
  ): List<LocationDto> =
    api.getCoordinatesByLocationName(query, limit, appId)
}
