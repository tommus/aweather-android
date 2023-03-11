package dev.windly.aweather.resources

import android.content.Context
import dagger.Reusable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Reusable
class HelloResources @Inject constructor(
  @ApplicationContext private val context: Context
) {

  fun hello(): CharSequence =
    context.getString(R.string.hello)
}
