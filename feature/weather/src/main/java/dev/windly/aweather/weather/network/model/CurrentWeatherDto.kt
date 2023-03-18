package dev.windly.aweather.weather.network.model

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
  val weather: List<WeatherDto> = emptyList(),

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

  /**
   * Visibility in meters. This value is coerced at 10.000 max.
   */
  @Json(name = "visibility")
  val visibility: Int = 0,

  /**
   * Wind details.
   */
  @Json(name = "wind")
  val wind: WindDto = WindDto(),

  /**
   * Cloudiness details.
   */
  @Json(name = "clouds")
  val clouds: CloudsDto = CloudsDto(),

  /**
   * Rainfall details.
   */
  @Json(name = "rain")
  val rain: FallDto? = null,

  /**
   * Snowfall details.
   */
  @Json(name = "snow")
  val snow: FallDto? = null,

  /**
   * Time of data calculation. UTC UNIX timezone.
   */
  @Json(name = "dt")
  val timestamp: Long = 0L,

  /**
   * System details.
   */
  @Json(name = "sys")
  val system: SysDto = SysDto(),

  /**
   * Shift in seconds from UTC.
   */
  @Json(name = "timezone")
  val timezone: Long = 0L,

  /**
   * City ID.
   */
  @Json(name = "id")
  val id: Long = 0L,

  /**
   * City name.
   */
  @Json(name = "name")
  val name: String = "",

  /**
   * Internal parameter.
   */
  @Json(name = "cod")
  val cod: Int = 0,
)
