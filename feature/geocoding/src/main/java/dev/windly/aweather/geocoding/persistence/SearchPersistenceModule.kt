package dev.windly.aweather.geocoding.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object SearchPersistenceModule {

  /**
   * Denotes a database name for the search module.
   */
  private const val DB_NAME = "geocoding.db"

  /**
   * Creates an instance of the [SearchDatabase] for use by DAOs.
   */
  @[Provides Singleton]
  internal fun database(@ApplicationContext context: Context): SearchDatabase =
    Room.databaseBuilder(context, SearchDatabase::class.java, DB_NAME)
      .fallbackToDestructiveMigration()
      .build()

  /**
   * Adds [LocationDao] to the dependency graph so it will become
   * injectable.
   */
  @[Provides Singleton]
  internal fun locationDao(database: SearchDatabase): LocationDao =
    database.locationDao()

  /**
   * Adds [RecentDao] to the dependency graph so it will become
   * injectable.
   */
  @[Provides Singleton]
  internal fun recentDao(database: SearchDatabase): RecentDao =
    database.recentDao()
}
