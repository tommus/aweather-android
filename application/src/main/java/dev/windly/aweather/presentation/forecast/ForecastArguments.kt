package dev.windly.aweather.presentation.forecast

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ForecastArguments @Inject constructor(
  private val handle: SavedStateHandle
) {

  private companion object {
    private const val LATITUDE = "latitude"
    private const val LONGITUDE = "longitude"
  }

  /**
   * Provides non-nullable access to the latitude.
   */
  fun requireLatitude(): Float =
    requireNotNull(handle.get<Float>(LATITUDE))

  /**
   * Provides non-nullable access to the longitude.
   */
  fun requireLongitude(): Float =
    requireNotNull(handle.get<Float>(LONGITUDE))
}
