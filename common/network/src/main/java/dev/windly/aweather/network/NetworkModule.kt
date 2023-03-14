package dev.windly.aweather.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.windly.aweather.configuration.Configuration
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object NetworkModule {

  @[Provides Singleton]
  internal fun moshi(): Moshi =
    Moshi.Builder().build()

  @[Provides Singleton]
  internal fun adapterFactory(): CallAdapter.Factory =
    RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())

  @[Provides Singleton]
  internal fun converterFactory(moshi: Moshi): Converter.Factory =
    MoshiConverterFactory.create(moshi)

  @[Provides Singleton]
  internal fun loggingLevel(configuration: Configuration): Level =
    when (configuration.isDebug()) {
      true -> Level.BODY
      else -> Level.NONE
    }

  @[Provides Singleton]
  internal fun loggingInterceptor(level: Level): HttpLoggingInterceptor =
    HttpLoggingInterceptor()
      .setLevel(level)

  // TODO:
  //  Add interceptors as per requirements:
  //  - authorization,
  //  - error handling,
  //  - session tracking.

  @[Provides Singleton]
  internal fun client(
    loggingInterceptor: HttpLoggingInterceptor
  ): OkHttpClient =
    OkHttpClient.Builder()
      .addInterceptor(loggingInterceptor)
      .build()

  @[Provides Singleton]
  internal fun retrofit(
    configuration: Configuration,
    adapterFactory: CallAdapter.Factory,
    converterFactory: Converter.Factory,
    client: OkHttpClient
  ): Retrofit =
    Retrofit.Builder()
      .addCallAdapterFactory(adapterFactory)
      .addConverterFactory(converterFactory)
      .baseUrl(configuration.openWeatherApiUrl())
      .client(client)
      .build()
}
