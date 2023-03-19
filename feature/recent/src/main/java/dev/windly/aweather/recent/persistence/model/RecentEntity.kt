package dev.windly.aweather.recent.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "recents",
  indices = [
    Index("name"),
    Index("name", "latitude", "longitude", unique = true),
  ],
)
data class RecentEntity(

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "name")
  var name: String = "",

  @ColumnInfo(name = "input")
  var input: String = "",

  @ColumnInfo(name = "latitude")
  var latitude: Double = 0.0,

  @ColumnInfo(name = "longitude")
  var longitude: Double = 0.0
)
