package dev.windly.aweather.geocoding.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.geocoding.persistence.model.LocationEntity
import dev.windly.aweather.geocoding.persistence.model.RecentEntity

@Database(
  version = 4,
  exportSchema = false,
  entities = [
    LocationEntity::class,
    RecentEntity::class,
  ]
)
internal abstract class SearchDatabase : RoomDatabase() {

  abstract fun locationDao(): LocationDao

  abstract fun recentDao(): RecentDao
}
