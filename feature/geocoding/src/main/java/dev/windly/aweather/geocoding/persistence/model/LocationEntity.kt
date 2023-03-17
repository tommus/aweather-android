package dev.windly.aweather.geocoding.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "locations",
  indices = [Index("name")],
)
data class LocationEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0,

  @ColumnInfo(name = "name")
  var name: String = "",

  // TODO: 13.03.2023 Create reference table for the local names.
  // var localNames: List<Pair<String, String>>? = null,

  @ColumnInfo(name = "latitude")
  var latitude: Double = 0.0,

  @ColumnInfo(name = "longitude")
  var longitude: Double = 0.0,

  @ColumnInfo(name = "country")
  var country: String = "",

  @ColumnInfo(name = "state")
  var state: String? = null
)
