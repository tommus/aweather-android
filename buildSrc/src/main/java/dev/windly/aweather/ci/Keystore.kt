package dev.windly.aweather.ci

object Keystore {
  private const val directory = "settings/keystore"

  object Debug {
    const val alias = "androiddebugkey"
    const val key = "android"
    const val path = "$directory/debug.jks"
  }

  object Release {

    // TODO: Change alias and key as per your requirements.
    // TODO: Generate release keystore in [directory].

    const val alias = "change"
    const val key = "change"
    const val path = "$directory/release.jks"
  }
}
