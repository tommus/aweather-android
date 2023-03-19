package dev.windly.aweather.presentation.forecast

import android.graphics.drawable.Drawable
import android.view.View

data class ForecastState(
  val name: CharSequence = "",
  val date: CharSequence = "",
  val temperature: CharSequence = "",
  val description: CharSequence = "",
  val icon: Drawable? = null,
  val range: CharSequence = "",
  val sunrise: CharSequence = "",
  val sunset: CharSequence = "",
  val pressure: CharSequence = "",
  val wind: CharSequence = "",
  val gusts: CharSequence = "",
  val visibility: CharSequence = "",
  val feelsLike: CharSequence = "",
  val humidity: CharSequence = "",
  val dewPoint: CharSequence = "",
  val rain: CharSequence = "",
  val snow: CharSequence = "",
  val loading: Int = View.GONE,
) {

  companion object {

    /**
     * Default representation of the [ForecastState].
     */
    val Empty = ForecastState()
  }
}
