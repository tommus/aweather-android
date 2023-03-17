package dev.windly.aweather.geocoding

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.geocoding.domain.GeocodingDomainRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class GeocodingModule {

  /**
   * Binds the [GeocodingDomainRepository] as a [GeocodingRepository].
   */
  @[Binds Singleton]
  internal abstract fun repository(
    domain: GeocodingDomainRepository): GeocodingRepository
}
