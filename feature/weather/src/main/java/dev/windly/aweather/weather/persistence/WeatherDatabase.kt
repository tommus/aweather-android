package dev.windly.aweather.weather.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import dev.windly.aweather.weather.persistence.model.WeatherEntity

@Database(
  version = 3,
  exportSchema = false,
  entities = [
    CurrentWeatherEntity::class,
    WeatherEntity::class,
  ]
)
internal abstract class WeatherDatabase : RoomDatabase() {

  abstract fun weatherDao(): CurrentWeatherDao
}
