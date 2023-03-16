package dev.windly.aweather.weather

/**
 * Immutable wrapper holding all the required details to retrieve
 * a weather forecast for a specified location.
 */
data class SearchCriteria(
  val latitude: Float,
  val longitude: Float,
  @MeasurementLang val language: String,
  @MeasurementUnit val units: String,
)
