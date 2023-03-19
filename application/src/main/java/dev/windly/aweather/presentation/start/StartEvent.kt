package dev.windly.aweather.presentation.start

import dev.windly.aweather.base.event.Event
import dev.windly.aweather.recent.domain.model.Recent

sealed class StartEvent : Event {

  /**
   * An event which occurs if the user has never reviewed the
   * forecast in the application yet.
   */
  object NavigateToFresh : StartEvent()

  /**
   * An event which occurs if the user has previously reviewed
   * the forecast in the application.
   */
  data class NavigateToVisited(val recent: Recent) : StartEvent()
}
