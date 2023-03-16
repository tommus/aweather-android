package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_descriptions")
data class WeatherEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "main")
  var main: String = "",

  @ColumnInfo(name = "description")
  var description: String = "",

  @ColumnInfo(name = "icon")
  var icon: String = "",

  @ColumnInfo(name = "currentId")
  var currentId: Long = 0L,
)
