package dev.windly.aweather.location.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.location.persistence.model.LocationEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    LocationEntity::class,
  ]
)
internal abstract class LocationDatabase : RoomDatabase() {

  abstract fun locationDao(): LocationDao
}
