package dev.windly.aweather.geocoding.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDto(

  /**
   * Name of the found location.
   */
  @Json(name = "name")
  val name: String = "",

  /**
   * Geographical coordinates of the found location (latitude).
   */
  @Json(name = "lat")
  val latitude: Double = 0.0,

  /**
   * Geographical coordinates of the found location (longitude).
   */
  @Json(name = "lon")
  val longitude: Double = 0.0,

  /**
   * Country of the found location.
   */
  @Json(name = "country")
  val country: String = "",

  /**
   * State of the found location (where available).
   */
  @Json(name = "state")
  val state: String? = null,
)
