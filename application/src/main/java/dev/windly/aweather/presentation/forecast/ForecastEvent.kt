package dev.windly.aweather.presentation.forecast

import dev.windly.aweather.base.event.Event
import dev.windly.aweather.presentation.search.SearchFragment

sealed class ForecastEvent : Event {

  /**
   * An event which occurs when user wants to navigate to the
   * [SearchFragment] in order to pick a different location for
   * which the weather forecast will be then retrieved..
   */
  object NavigateToFindLocation : ForecastEvent()
}
