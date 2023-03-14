package dev.windly.aweather.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDto(

  /**
   * Wind speed.
   *
   * Metric: meter / sec.
   * Imperial: miles / hour.
   *
   * Customizable by units.
   */
  @Json(name = "speed")
  val speed: Float = 0.0f,

  /**
   * Wind direction in degrees.
   */
  @Json(name = "deg")
  val degree: Int = 0,

  /**
   * Wind gust.
   *
   * Metric: meter / sec.
   * Imperial: miles / hour.
   *
   * Customizable by units.
   */
  @Json(name = "gust")
  val gust: Float = 0.0f,
)
