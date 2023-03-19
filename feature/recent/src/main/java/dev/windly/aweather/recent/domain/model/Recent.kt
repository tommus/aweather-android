package dev.windly.aweather.recent.domain.model

data class Recent(
  var id: Long = 0L,
  var name: String = "",
  var input: String = "",
  var latitude: Double = 0.0,
  var longitude: Double = 0.0
)
