package dev.windly.aweather.presentation.start

data class StartViewState(
  val data: CharSequence
) {

  companion object {

    /**
     * A default representation of a [StartViewState].
     */
    val Empty = StartViewState(data = "")
  }
}
