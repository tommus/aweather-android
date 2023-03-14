package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "forecasts",
  indices = [Index("name")],
)
data class CurrentWeatherEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0,

  @ColumnInfo(name = "name")
  var name: String = "",

  // TODO: 14.03.2023 Implement the rest of the cache.
)
