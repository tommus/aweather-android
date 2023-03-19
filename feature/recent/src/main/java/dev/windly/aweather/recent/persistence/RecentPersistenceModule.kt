package dev.windly.aweather.recent.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object RecentPersistenceModule {

  /**
   * Denotes a database name for the search module.
   */
  private const val DB_NAME = "recent.db"

  /**
   * Creates an instance of the [RecentDatabase] for use by DAOs.
   */
  @[Provides Singleton]
  internal fun database(@ApplicationContext context: Context): RecentDatabase =
    Room.databaseBuilder(context, RecentDatabase::class.java, DB_NAME)
      .fallbackToDestructiveMigration()
      .build()

  /**
   * Adds [RecentDao] to the dependency graph so it will become
   * injectable.
   */
  @[Provides Singleton]
  internal fun recentDao(database: RecentDatabase): RecentDao =
    database.recentDao()
}
