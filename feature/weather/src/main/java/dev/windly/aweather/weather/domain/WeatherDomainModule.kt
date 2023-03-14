package dev.windly.aweather.weather.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object WeatherDomainModule {

  /**
   * Instantiates the [WeatherMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun mapper(): WeatherMapper =
    Mappers.getMapper(WeatherMapper::class.java)
}
