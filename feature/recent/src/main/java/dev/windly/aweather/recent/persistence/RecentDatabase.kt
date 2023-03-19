package dev.windly.aweather.recent.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.recent.persistence.model.RecentEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    RecentEntity::class,
  ]
)
internal abstract class RecentDatabase : RoomDatabase() {

  abstract fun recentDao(): RecentDao
}
