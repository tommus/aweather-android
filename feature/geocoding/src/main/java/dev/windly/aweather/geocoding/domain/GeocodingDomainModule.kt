package dev.windly.aweather.geocoding.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object GeocodingDomainModule {

  /**
   * Instantiates the [GeocodingMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun geocodingMapper(): GeocodingMapper =
    Mappers.getMapper(GeocodingMapper::class.java)

  /**
   * Instantiates the [RecentMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun recentMapper(): RecentMapper =
    Mappers.getMapper(RecentMapper::class.java)
}
