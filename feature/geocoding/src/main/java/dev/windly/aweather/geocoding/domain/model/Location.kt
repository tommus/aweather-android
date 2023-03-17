package dev.windly.aweather.geocoding.domain.model

data class Location(
  val id: Long = 0,
  val name: String = "",
  val localNames: List<Pair<String, String>>? = null,
  val latitude: Double = 0.0,
  val longitude: Double = 0.0,
  val country: String = "",
  val state: String? = null
)
