package dev.windly.aweather.time

import dagger.Reusable
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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
    timestamp.instant().localTime().format(withTimeFormatter())

  /**
   * Formatter used to format time in "HH:mm" format.
   */
  private fun withTimeFormatter(): DateTimeFormatter =
    DateTimeFormatter.ofPattern(TIME_FORMAT)

  /**
   * Use system default timezone.
   */
  private fun timezone(): ZoneId =
    ZoneId.systemDefault()

  /**
   * Creates [LocalDateTime] from UNIX timestamp.
   */
  private fun Instant.localTime(): LocalDateTime =
    LocalDateTime.ofInstant(this, timezone())

  /**
   * Creates [Instant] from UNIX timestamp in seconds.
   */
  private fun Long.instant(): Instant =
    Instant.ofEpochSecond(this)
}
