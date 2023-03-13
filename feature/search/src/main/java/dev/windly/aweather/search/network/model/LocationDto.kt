package dev.windly.aweather.search.network.model

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
   * Name of the found location in different languages.
   * [Pair.first] - a language code.
   * [Pair.second] - a translated location name.
   */
  @Json(name = "local_names")
  val localNames: List<Pair<String, String>>? = null,

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
  val state: String? = null
)
