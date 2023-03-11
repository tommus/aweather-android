@file:Suppress("UnstableApiUsage")

import Build_gradle.Key.URL
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
  const val URL = "URL"
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

      // TODO: Add injectable configuration.
      buildConfigField("String", URL, findProperty("ApiUrlDebug").toString())
    }
    release {
      isMinifyEnabled = false

      // TODO: Add injectable configuration.
      buildConfigField("String", URL, findProperty("ApiUrlRelease").toString())
    }
  }
}

dependencies {
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
