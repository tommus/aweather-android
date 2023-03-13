package dev.windly.aweather.search

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.search.domain.SearchDomainRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class SearchModule {

  /**
   * Binds the [SearchDomainRepository] as a [SearchRepository].
   */
  @[Binds Singleton]
  internal abstract fun repository(
    domain: SearchDomainRepository): SearchRepository
}
