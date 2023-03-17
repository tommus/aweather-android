package dev.windly.aweather.presentation.forecast

import android.view.View

data class ForecastState(
  val name: CharSequence = "",
  val temperature: CharSequence = "",
  val description: CharSequence = "",
  val range: CharSequence = "",
  val sunrise: CharSequence = "",
  val sunset: CharSequence = "",
  val loading: Int = View.GONE,
) {

  companion object {

    /**
     * Default representation of a [ForecastState].
     */
    val Empty = ForecastState()
  }
}
