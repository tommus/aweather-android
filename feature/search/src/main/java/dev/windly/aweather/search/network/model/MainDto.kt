package dev.windly.aweather.search.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainDto(

  /**
   * Temperature.
   *
   * Customizable by units.
   */
  @Json(name = "temp")
  val temperature: Float = 0.0f,

  /**
   * Temperature. This temperature parameter accounts
   * for the human perception of weather.
   *
   * Customizable by units.
   */
  @Json(name = "feels_like")
  val feelsLike: Float = 0.0f,

  /**
   * Atmospheric pressure (on the sea level) in hPa.
   */
  @Json(name = "pressure")
  val pressure: Int = 0,

  /**
   * Humidity in percentage.
   */
  @Json(name = "humidity")
  val humidity: Int = 0,

  /**
   * Minimum temperature at the moment. This is minimal currently observed
   * temperature (within large megalopolises and urban areas).
   *
   * Customizable by units.
   */
  @Json(name = "temp_min")
  val minimalTemperature: Float = 0.0f,

  /**
   * Maximum temperature at the moment. This is maximal currently observed
   * temperature (within large megalopolises and urban areas).
   *
   * Customizable by units.
   */
  @Json(name = "temp_max")
  val maximalTemperature: Float = 0.0f,

  /**
   * Atmospheric pressure on the sea level in hPa.
   */
  @Json(name = "sea_level")
  val seaLevel: Int = 0,

  /**
   * Atmospheric pressure on the ground level in hPa.
   */
  @Json(name = "grnd_level")
  val groundLevel: Int = 0,
)
