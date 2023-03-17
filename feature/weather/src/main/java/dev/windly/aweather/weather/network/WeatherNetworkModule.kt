package dev.windly.aweather.weather.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class WeatherNetworkModule @Inject constructor() {

  @[Provides Singleton]
  internal fun api(retrofit: Retrofit): CurrentWeatherApi =
    retrofit.create()
}
