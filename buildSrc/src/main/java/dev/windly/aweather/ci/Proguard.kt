package dev.windly.aweather.ci

object Proguard {

  /**
   * Default file name for library consumer rules.
   */
  const val CONSUMER = "consumer-rules.pro"

  /**
   * Default file name for application proguard rules.
   */
  private const val RULES = "proguard-rules.pro"

  /**
   * Provides a filename of the regular proguard rules.
   */
  fun rules(): String = RULES
}
