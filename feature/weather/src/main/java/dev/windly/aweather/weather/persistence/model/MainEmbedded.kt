package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class MainEmbedded(

  @ColumnInfo(name = "temp")
  var temperature: Float = 0.0f,

  @ColumnInfo(name = "feels_like")
  var feelsLike: Float = 0.0f,

  @ColumnInfo(name = "pressure")
  var pressure: Int = 0,

  @ColumnInfo(name = "humidity")
  var humidity: Int = 0,

  @ColumnInfo(name = "temp_min")
  var minimalTemperature: Float = 0.0f,

  @ColumnInfo(name = "temp_max")
  var maximalTemperature: Float = 0.0f,

  @ColumnInfo(name = "sea_level")
  var seaLevel: Int? = null,

  @ColumnInfo(name = "grnd_level")
  var groundLevel: Int? = null,
)
