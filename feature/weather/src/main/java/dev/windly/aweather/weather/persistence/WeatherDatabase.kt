package dev.windly.aweather.weather.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    CurrentWeatherEntity::class,
  ]
)
internal abstract class WeatherDatabase : RoomDatabase() {

  abstract fun weatherDao(): CurrentWeatherDao
}
