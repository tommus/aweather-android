package dev.windly.aweather.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Reusable
class WeatherIconResources @Inject constructor(
  @ApplicationContext private val context: Context,
) {

  fun clearSkyDay(): Drawable =
    context.drawable(R.drawable.weather_01d)

  fun clearSkyNight(): Drawable =
    context.drawable(R.drawable.weather_01n)

  fun fewCloudsDay(): Drawable =
    context.drawable(R.drawable.weather_02d)

  fun fewCloudsNight(): Drawable =
    context.drawable(R.drawable.weather_02n)

  fun scatteredClouds(): Drawable =
    context.drawable(R.drawable.weather_03dn)

  fun brokenClouds(): Drawable =
    context.drawable(R.drawable.weather_04dn)

  fun showerRainDay(): Drawable =
    context.drawable(R.drawable.weather_09d)

  fun showerRainNight(): Drawable =
    context.drawable(R.drawable.weather_09n)

  fun rainDay(): Drawable =
    context.drawable(R.drawable.weather_10d)

  fun rainNight(): Drawable =
    context.drawable(R.drawable.weather_10n)

  fun thunderstormDay(): Drawable =
    context.drawable(R.drawable.weather_11d)

  fun thunderstormNight(): Drawable =
    context.drawable(R.drawable.weather_11n)

  fun snowDay(): Drawable =
    context.drawable(R.drawable.weather_13d)

  fun snowNight(): Drawable =
    context.drawable(R.drawable.weather_13n)

  fun mistDay(): Drawable =
    context.drawable(R.drawable.weather_50d)

  fun mistNight(): Drawable =
    context.drawable(R.drawable.weather_50n)

  /**
   * Provides non-nullable access to the [Drawable].
   */
  private fun Context.drawable(@DrawableRes resId: Int): Drawable =
    AppCompatResources.getDrawable(context, resId)
      ?: throw IllegalArgumentException("Cannot access drawable.")
}
