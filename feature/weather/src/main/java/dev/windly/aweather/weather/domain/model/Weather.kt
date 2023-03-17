package dev.windly.aweather.weather.domain.model

data class Weather(
  var id: Long = 0L,
  var main: String = "",
  var description: String = "",
  var icon: String = "",
)
