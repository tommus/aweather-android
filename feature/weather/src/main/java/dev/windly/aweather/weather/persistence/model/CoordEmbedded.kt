package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class CoordEmbedded(

  @ColumnInfo(name = "latitude")
  var latitude: Float = 0.0f,

  @ColumnInfo(name = "longitude")
  var longitude: Float = 0.0f,
)
