package dev.windly.aweather.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudsDto(

  /**
   * Cloudiness in percent.
   */
  @Json(name = "all")
  val all: Int = 0,
)
