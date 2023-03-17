package dev.windly.aweather.weather.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.weather.domain.mapper.CurrentWeatherMapper
import dev.windly.aweather.weather.domain.mapper.WeatherMapper
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object WeatherDomainModule {

  /**
   * Instantiates the [CurrentWeatherMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun currentWeatherMapper(): CurrentWeatherMapper =
    Mappers.getMapper(CurrentWeatherMapper::class.java)

  /**
   * Instantiates the [WeatherMapper] and scopes it to the
   * [SingletonComponent].
   */
  @[Provides Singleton]
  internal fun weatherMapper(): WeatherMapper =
    Mappers.getMapper(WeatherMapper::class.java)
}
