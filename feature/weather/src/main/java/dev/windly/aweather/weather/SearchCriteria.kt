package dev.windly.aweather.weather

/**
 * Immutable wrapper holding all the required details to download a
 * weather forecast for a specified location.
 */
data class SearchCriteria(
  val latitude: Float,
  val longitude: Float
)
