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
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactive.asFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
  private val arguments: ForecastArguments,
  private val factory: ForecastStateFactory,
  private val forecast: ForecastWeather,
  private val repository: WeatherRepository,
) : ViewModel(), DefaultLifecycleObserver {

  private val _navigation = Channel<ForecastEvent>()

  /**
   * Asynchronously emits events that relates to the navigation between
   * the screens.
   *
   * Observer of this stream should subscribe to this flow and perform
   * navigation operations on behalf of the user.
   */
  internal val navigation: Flow<ForecastEvent> =
    _navigation.receiveAsFlow()

  private val loading: CompletableProgress =
    CompletableProgress()

  private val subscriptions: CompositeDisposable =
    CompositeDisposable()

  private val _forecast: StateFlow<CurrentWeather> =
    forecast.observe().asFlow()
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

  fun onFindLocationClicked() = viewModelScope.launch {
    _navigation.send(ForecastEvent.NavigateToFindLocation)
  }
}
