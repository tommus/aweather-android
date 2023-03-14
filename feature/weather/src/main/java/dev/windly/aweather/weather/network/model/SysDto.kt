package dev.windly.aweather.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SysDto(

  /**
   * Internal parameter.
   */
  @Json(name = "type")
  val type: Int = 0,

  /**
   * Internal parameter.
   */
  @Json(name = "id")
  val id: Long = 0L,

  /**
   * Internal parameter.
   */
  @Json(name = "message")
  val message: String = "",

  /**
   * Country code (ISO 3166 Alpha-2 code).
   */
  @Json(name = "country")
  val country: String = "",

  /**
   * Sunrise time. UTC UNIX timestamp.
   */
  @Json(name = "sunrise")
  val sunrise: Long = 0L,

  /**
   * Sunset time. UTC UNIX timestamp.
   */
  @Json(name = "sunset")
  val sunset: Long = 0L,
)
