package dev.windly.aweather.search.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherDto(

  /**
   * City geo location.
   */
  @Json(name = "coord")
  val coordinates: CoordDto = CoordDto(),

  /**
   * Weather condition information.
   */
  @Json(name = "weather")
  val weather: WeatherDto = WeatherDto(),

  /**
   * Internal parameter.
   */
  @Json(name = "base")
  val base: String = "",

  /**
   * Main weather details.
   */
  @Json(name = "main")
  val main: MainDto = MainDto(),

  // TODO: 13.03.2023 Extend DTO with other details:
  //  - visibility
  //  - wind
  //  - clouds
  //  - rain
  //  - snow
  //  - dt
  //  - sys
  //  - timezone
  //  - id
  //  - name
  //  - cod
)
