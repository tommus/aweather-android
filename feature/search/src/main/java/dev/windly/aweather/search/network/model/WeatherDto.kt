package dev.windly.aweather.search.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(

  /**
   * Weather condition id.
   */
  @Json(name = "id")
  val id: Long = 0L,

  /**
   * Group of weather parameters such as rain, snow, extreme,
   * etc.
   */
  @Json(name = "main")
  val main: String = "",

  /**
   * Weather condition within the group. Customizable by
   * language.
   */
  @Json(name = "description")
  val description: String = "",

  /**
   * Weather icon id.
   */
  @Json(name = "icon")
  val icon: String = ""
)
