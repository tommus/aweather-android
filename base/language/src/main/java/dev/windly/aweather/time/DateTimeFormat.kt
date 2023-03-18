package dev.windly.aweather.time

import dagger.Reusable
import org.joda.time.DateTime
import org.joda.time.LocalTime
import javax.inject.Inject

@Reusable
class DateTimeFormat @Inject constructor() {

  private companion object {
    private const val DAY_MONTH_FORMAT = "dd MMMM, EEEE"
    private const val TIME_FORMAT = "HH:mm"
  }

  /**
   * Formats today as a text containing day, month and day o week.
   */
  fun todayAsText(): CharSequence =
    DateTime.now().toString(DAY_MONTH_FORMAT)

  /**
   * Formats a time part of a UNIX timestamp as a text.
   */
  fun timeAsText(timestamp: Long): CharSequence =
    LocalTime(timestamp * 1_000L).toString(TIME_FORMAT)
}
