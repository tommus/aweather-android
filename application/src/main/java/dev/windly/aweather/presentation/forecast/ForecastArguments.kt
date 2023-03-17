package dev.windly.aweather.presentation.forecast

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.presentation.forecast.ForecastFragmentArgs.Companion.fromSavedStateHandle
import javax.inject.Inject

@ViewModelScoped
class ForecastArguments @Inject constructor(handle: SavedStateHandle) {

  /**
   * Extracts arguments from the [SavedStateHandle].
   */
  private val arguments = fromSavedStateHandle(handle)

  /**
   * Provides non-nullable access to the latitude.
   */
  fun requireLatitude(): Float = arguments.latitude

  /**
   * Provides non-nullable access to the longitude.
   */
  fun requireLongitude(): Float = arguments.longitude
}
