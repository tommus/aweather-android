package dev.windly.aweather.presentation.forecast

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.weather.SearchCriteria
import dev.windly.aweather.weather.WeatherRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
  private val arguments: ForecastArguments,
  private val repository: WeatherRepository
) : ViewModel(), DefaultLifecycleObserver {

  private val subscriptions = CompositeDisposable()

  override fun onStart(owner: LifecycleOwner) {
    super.onStart(owner)

    val disposable =
      repository
        .downloadForecast(arguments.asCriteria())
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

  private fun ForecastArguments.asCriteria(): SearchCriteria =
    SearchCriteria(
      latitude = requireLatitude(),
      longitude = requireLongitude()
    )
}

