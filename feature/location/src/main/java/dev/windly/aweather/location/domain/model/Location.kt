package dev.windly.aweather.location.domain.model

data class Location(
  var id: Long = 0L,
  var name: String = "",
  var latitude: Double = 0.0,
  var longitude: Double = 0.0,
  var country: String = "",
  var state: String? = null
)
