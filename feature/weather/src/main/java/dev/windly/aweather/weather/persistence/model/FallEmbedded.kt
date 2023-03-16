package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class FallEmbedded(

  @ColumnInfo(name = "1h")
  var oneHour: Float? = null,

  @ColumnInfo(name = "3h")
  var threeHours: Float? = null,
)
