package dev.windly.aweather.recent.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object RecentDomainModule {

  /**
   * Instantiates the [RecentMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun recentMapper(): RecentMapper =
    Mappers.getMapper(RecentMapper::class.java)
}
