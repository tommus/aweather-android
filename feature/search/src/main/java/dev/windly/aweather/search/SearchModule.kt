package dev.windly.aweather.search

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.search.domain.SearchDomainRepository

@[Module InstallIn(SingletonComponent::class)]
abstract class SearchModule {

  /**
   * Binds the [SearchDomainRepository] as a [SearchRepository].
   */
  internal abstract fun repository(
    domain: SearchDomainRepository): SearchRepository
}
