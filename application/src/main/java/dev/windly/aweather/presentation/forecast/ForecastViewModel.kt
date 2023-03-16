package dev.windly.aweather.presentation.forecast

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.weather.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
  private val arguments: ForecastArguments,
  private val repository: WeatherRepository
) : ViewModel()

