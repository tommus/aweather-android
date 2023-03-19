package dev.windly.aweather.location.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "locations",
  indices = [Index("name")],
)
data class LocationEntity(

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "name")
  var name: String = "",

  @ColumnInfo(name = "latitude")
  var latitude: Double = 0.0,

  @ColumnInfo(name = "longitude")
  var longitude: Double = 0.0,

  @ColumnInfo(name = "country")
  var country: String = "",

  @ColumnInfo(name = "state")
  var state: String? = null
)
