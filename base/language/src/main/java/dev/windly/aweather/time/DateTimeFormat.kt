package dev.windly.aweather.time

import dagger.Reusable
import org.joda.time.LocalTime
import javax.inject.Inject

@Reusable
class DateTimeFormat @Inject constructor() {

  private companion object {
    private const val TIME_FORMAT = "HH:mm"
  }

  /**
   * Formats a time part of a UNIX timestamp as a text.
   */
  fun timeAsText(timestamp: Long): CharSequence =
    LocalTime(timestamp * 1_000L).toString(TIME_FORMAT)
}
