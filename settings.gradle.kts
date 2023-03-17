@file:Suppress("UnstableApiUsage")

include(":application")
include(":base:android")
include(":base:language")
include(":base:mvvm")
include(":common:network")
include(":common:persistence")
include(":configuration")
include(":feature:geocoding")
include(":feature:weather")
include(":resources")

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven(url = "https://jitpack.io")
  }
}
