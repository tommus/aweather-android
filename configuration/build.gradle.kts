@file:Suppress("UnstableApiUsage")

import Build_gradle.Key.OPEN_WEATHER_API_URL
import Build_gradle.Key.OPEN_WEATHER_APP_ID
import dev.windly.aweather.ci.Application.packageName
import dev.windly.aweather.ci.Build
import dev.windly.aweather.ci.Build.Android
import dev.windly.aweather.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

object Key {
  const val OPEN_WEATHER_API_URL = "OPEN_WEATHER_API_URL"
  const val OPEN_WEATHER_APP_ID = "OPEN_WEATHER_APP_ID"
}

android {

  namespace = "$packageName.configuration"

  compileOptions {
    sourceCompatibility = Build.Version.java
    targetCompatibility = Build.Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    consumerProguardFiles(CONSUMER)
    minSdk = Android.minSdk
  }

  buildTypes {
    debug {
      isMinifyEnabled = false

      buildConfigField(
        type = "String",
        name = OPEN_WEATHER_API_URL,
        value = findProperty("OpenWeatherApiUrlRelease").toString(),
      )
      buildConfigField(
        type = "String",
        name = OPEN_WEATHER_APP_ID,
        value = findProperty("OpenWeatherAppIdDebug").toString(),
      )
    }
    release {
      isMinifyEnabled = false

      buildConfigField(
        type = "String",
        name = OPEN_WEATHER_API_URL,
        value = findProperty("OpenWeatherApiUrlRelease").toString(),
      )
      buildConfigField(
        type = "String",
        name = OPEN_WEATHER_APP_ID,
        value = findProperty("OpenWeatherAppIdRelease").toString(),
      )
    }
  }
}

dependencies {
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
