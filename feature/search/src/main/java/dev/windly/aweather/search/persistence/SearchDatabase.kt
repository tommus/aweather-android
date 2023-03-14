package dev.windly.aweather.search.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.search.persistence.model.LocationEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    LocationEntity::class,
  ]
)
internal abstract class SearchDatabase : RoomDatabase() {

  abstract fun locationDao(): LocationDao
}
