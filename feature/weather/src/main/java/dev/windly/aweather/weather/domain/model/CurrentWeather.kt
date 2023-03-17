package dev.windly.aweather.weather.domain.model

data class CurrentWeather(
  var coordinates: Coord = Coord(),
  var weather: List<Weather> = emptyList(),
  var base: String = "",
  var main: Main = Main(),
  var visibility: Int = 0,
  var wind: Wind = Wind(),
  var clouds: Clouds = Clouds(),
  var rain: Fall = Fall(),
  var snow: Fall = Fall(),
  var timestamp: Long = 0L,
  var system: Sys = Sys(),
  var timezone: Long = 0L,
  var id: Long = 0,
  var name: String = "",
  var cod: Int = 0,
)
