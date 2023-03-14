package dev.windly.aweather.weather.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object WeatherPersistenceModule {

  /**
   * Denotes a database name for the search module.
   */
  private const val DB_NAME = "weather.db"

  /**
   * Creates an instance of the [WeatherDatabase] for use by DAOs.
   */
  @[Provides Singleton]
  internal fun database(@ApplicationContext context: Context): WeatherDatabase =
    Room.databaseBuilder(context, WeatherDatabase::class.java, DB_NAME)
      .fallbackToDestructiveMigration()
      .build()

  /**
   * Adds [CurrentWeatherDao] to the dependency graph so it will become
   * injectable.
   */
  @[Provides Singleton]
  internal fun weatherDao(database: WeatherDatabase): CurrentWeatherDao =
    database.weatherDao()
}
