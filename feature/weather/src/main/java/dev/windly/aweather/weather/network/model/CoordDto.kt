package dev.windly.aweather.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordDto(

  /**
   * City geo location, longitude.
   */
  @Json(name = "lon")
  val longitude: Double = 0.0,

  /**
   * City geo location, latitude.
   */
  @Json(name = "lat")
  val latitude: Double = 0.0,
)
