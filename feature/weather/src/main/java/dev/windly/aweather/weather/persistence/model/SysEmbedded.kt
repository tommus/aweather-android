package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo

data class SysEmbedded(

  @ColumnInfo(name = "type")
  var type: Int = 0,

  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "message")
  var message: String = "",

  @ColumnInfo(name = "country")
  var country: String = "",

  @ColumnInfo(name = "sunrise")
  var sunrise: Long = 0L,

  @ColumnInfo(name = "sunset")
  var sunset: Long = 0L,
)
