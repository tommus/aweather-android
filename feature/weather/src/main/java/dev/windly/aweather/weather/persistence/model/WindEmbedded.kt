package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class WindEmbedded(

  @ColumnInfo(name = "speed")
  var speed: Float = 0.0f,

  @ColumnInfo(name = "deg")
  var degree: Int = 0,

  @ColumnInfo(name = "gust")
  var gust: Float = 0.0f,
)
