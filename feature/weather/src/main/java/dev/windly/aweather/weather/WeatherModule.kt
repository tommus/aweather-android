package dev.windly.aweather.weather

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.weather.domain.WeatherDomainRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class WeatherModule {

  /**
   * Binds the [WeatherDomainRepository] as a [WeatherRepository].
   */
  @[Binds Singleton]
  internal abstract fun repository(
    domain: WeatherDomainRepository): WeatherRepository
}
