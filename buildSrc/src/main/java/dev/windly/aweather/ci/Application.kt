package dev.windly.aweather.ci

object Application {
  const val packageName = "dev.windly.aweather"

  private const val applicationName = "Aweather"
  private const val debugNameSuffix = "Development"

  object Debug {
    private const val dev = "dev"
    const val packageSuffix = ".$dev"
    const val versionSuffix = "($dev)"
  }

  /**
   * Provides a release application name.
   */
  fun releaseAppName(): String = applicationName

  /**
   * Provides a debug application name.
   */
  fun debugAppName(): String = "$applicationName $debugNameSuffix"
}
