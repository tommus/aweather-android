package dev.windly.aweather.presentation.search

import dev.windly.aweather.base.event.Event
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.presentation.forecast.ForecastFragment

sealed class SearchEvent : Event {

  /**
   * An event which occurs when user wants to navigate to the
   * [ForecastFragment] in order to review the forecast of the
   * selected [Location].
   */
  data class NavigateToForecast(val location: Location) : SearchEvent()
}
