package dev.windly.aweather.location

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.location.domain.LocationDomainRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class LocationModule {

  /**
   * Binds the [LocationDomainRepository] as a [LocationRepository].
   */
  @[Binds Singleton]
  internal abstract fun repository(
    domain: LocationDomainRepository): LocationRepository
}
