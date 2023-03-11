package dev.windly.aweather.presentation.start

import dagger.Reusable
import dev.windly.aweather.resources.HelloResources
import javax.inject.Inject

@Reusable
class StartResources @Inject constructor(
  private val resources: HelloResources
) {

  internal fun hello(): CharSequence =
    resources.hello()
}
