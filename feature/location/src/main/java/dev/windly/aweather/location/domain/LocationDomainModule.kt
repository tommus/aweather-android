package dev.windly.aweather.location.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object LocationDomainModule {

  /**
   * Instantiates the [LocationMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun locationMapper(): LocationMapper =
    Mappers.getMapper(LocationMapper::class.java)
}
