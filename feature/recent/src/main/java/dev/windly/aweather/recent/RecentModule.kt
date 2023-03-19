package dev.windly.aweather.recent

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.recent.domain.RecentDomainRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class RecentModule {

  /**
   * Binds the [RecentDomainRepository] as a [RecentRepository].
   */
  @[Binds Singleton]
  internal abstract fun repository(
    domain: RecentDomainRepository): RecentRepository
}
