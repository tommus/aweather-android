package dev.windly.aweather.search.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object SearchDomainModule {

  /**
   * Instantiates the [SearchMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun mapper(): SearchMapper =
    Mappers.getMapper(SearchMapper::class.java)
}
