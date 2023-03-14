package dev.windly.aweather.search.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FallDto(

  /**
   * Rain or snow volume for the last one hour
   * (in millimeters).
   */
  @Json(name = "1h")
  val oneHour: Float? = null,

  /**
   * Rain or snow volume for the last three hours
   * (in millimeters).
   */
  @Json(name = "3h")
  val threeHours: Float? = null,
)
