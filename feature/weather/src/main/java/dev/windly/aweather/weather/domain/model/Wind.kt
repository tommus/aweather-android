package dev.windly.aweather.weather.domain.model

data class Wind(
  var speed: Float = 0.0f,
  var degree: Int = 0,
  var gust: Float = 0.0f,
)
