package dev.windly.aweather.weather.domain.model

data class Main(
  var temperature: Float = 0.0f,
  var feelsLike: Float = 0.0f,
  var pressure: Int = 0,
  var humidity: Int = 0,
  var minimalTemperature: Float = 0.0f,
  var maximalTemperature: Float = 0.0f,
  var seaLevel: Int? = null,
  var groundLevel: Int? = null,
)
