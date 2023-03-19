package dev.windly.aweather.location.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class LocationNetworkModule @Inject constructor() {

  @[Provides Singleton]
  internal fun api(retrofit: Retrofit): LocationApi =
    retrofit.create()
}
