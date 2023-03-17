package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class CloudsEmbedded(

  @ColumnInfo(name = "all")
  var all: Int = 0,
)
