package dev.windly.aweather.weather.domain

import dev.windly.aweather.configuration.Configuration
import dev.windly.aweather.weather.WeatherRepository
import dev.windly.aweather.weather.network.CurrentWeatherApi
import dev.windly.aweather.weather.persistence.CurrentWeatherDao
import javax.inject.Inject

class WeatherDomainRepository @Inject constructor(
  private val api: CurrentWeatherApi,
  private val configuration: Configuration,
  private val dao: CurrentWeatherDao,
  private val mapper: WeatherMapper
) : WeatherRepository {

  // TODO: 14.03.2023 Implement interface once defined.
}
