package dev.windly.aweather.weather.domain.model

data class Sys(
  var type: Int = 0,
  var id: Long = 0L,
  var message: String? = null,
  var country: String = "",
  var sunrise: Long = 0L,
  var sunset: Long = 0L,
)
