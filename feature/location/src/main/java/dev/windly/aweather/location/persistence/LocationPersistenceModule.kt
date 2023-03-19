package dev.windly.aweather.location.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object LocationPersistenceModule {

  /**
   * Denotes a database name for the search module.
   */
  private const val DB_NAME = "location.db"

  /**
   * Creates an instance of the [LocationDatabase] for use by DAOs.
   */
  @[Provides Singleton]
  internal fun database(@ApplicationContext context: Context): LocationDatabase =
    Room.databaseBuilder(context, LocationDatabase::class.java, DB_NAME)
      .fallbackToDestructiveMigration()
      .build()

  /**
   * Adds [LocationDao] to the dependency graph so it will become
   * injectable.
   */
  @[Provides Singleton]
  internal fun locationDao(database: LocationDatabase): LocationDao =
    database.locationDao()
}
