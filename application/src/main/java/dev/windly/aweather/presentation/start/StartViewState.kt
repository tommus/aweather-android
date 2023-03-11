package dev.windly.aweather.presentation.start

data class StartViewState(
  val data: CharSequence
) {

  companion object {

    /**
     * Creates a default representation of [start view state][StartViewState].
     */
    fun empty(): StartViewState =
      StartViewState(data = "")
  }
}
