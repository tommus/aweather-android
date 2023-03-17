package dev.windly.aweather.presentation.forecast

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.android.reactivex.CompletableProgress
import dev.windly.aweather.weather.MeasurementLang
import dev.windly.aweather.weather.MeasurementUnit
import dev.windly.aweather.weather.SearchCriteria
import dev.windly.aweather.weather.WeatherRepository
import dev.windly.aweather.weather.domain.model.CurrentWeather
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.reactive.asFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
  private val arguments: ForecastArguments,
  private val factory: ForecastStateFactory,
  private val repository: WeatherRepository
) : ViewModel(), DefaultLifecycleObserver {

  private val loading: CompletableProgress =
    CompletableProgress()

  private val subscriptions: CompositeDisposable =
    CompositeDisposable()

  private val _forecast: StateFlow<CurrentWeather> =
    repository
      .observeWeather(perCriteria()).asFlow()
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = CurrentWeather()
      )

  val state: StateFlow<ForecastState> =
    combine(_forecast, loading.progress, factory::create)
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = ForecastState.Empty
      )

  override fun onStart(owner: LifecycleOwner) {
    super.onStart(owner)

    val disposable =
      repository
        .downloadForecast(perCriteria())
        .compose(withLoadingProgress())
        .subscribe(
          ::onForecastDownloaded,
          ::onForecastDownloadError
        )
    subscriptions.add(disposable)
  }

  private fun onForecastDownloaded() {
    Timber.v("Weather forecast was successfully downloaded.")
  }

  private fun onForecastDownloadError(throwable: Throwable) {
    Timber.e(
      message = "An error occurred while downloading a weather forecast.",
      throwable
    )
  }

  private fun perCriteria(): SearchCriteria =
    SearchCriteria(
      latitude = arguments.requireLatitude(),
      longitude = arguments.requireLongitude(),
      language = MeasurementLang.POLISH,
      units = MeasurementUnit.METRIC,
    )

  private fun withLoadingProgress(): CompletableProgress =
    loading
}
