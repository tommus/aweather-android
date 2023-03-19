package dev.windly.aweather.presentation.search

import dev.windly.aweather.base.event.Event
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.presentation.forecast.ForecastFragment
import dev.windly.aweather.recent.domain.model.Recent

sealed class SearchEvent : Event {

  /**
   * An event which occurs when user wants to navigate to the
   * [ForecastFragment] in order to review the forecast of the
   * selected [Recent].
   */
  data class NavigateWithRecent(val recent: Recent) : SearchEvent()

  /**
   * An event which occurs when user wants to navigate to the
   * [ForecastFragment] in order to review the forecast of the
   * selected [Location].
   */
  data class NavigateWithLocation(val location: Location) : SearchEvent()
}
