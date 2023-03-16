package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class WeatherEmbedded(

  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "main")
  var main: String = "",

  @ColumnInfo(name = "description")
  var description: String = "",

  @ColumnInfo(name = "icon")
  var icon: String = "",
)
