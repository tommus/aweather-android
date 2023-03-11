@file:Suppress("UnstableApiUsage")

import dev.windly.aweather.ci.Application.packageName
import dev.windly.aweather.ci.Build
import dev.windly.aweather.ci.Build.Android
import dev.windly.aweather.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "$packageName.resources"

  buildFeatures {
    buildConfig = false
  }

  compileOptions {
    sourceCompatibility = Build.Version.java
    targetCompatibility = Build.Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    consumerProguardFiles(CONSUMER)
    minSdk = Android.minSdk
  }
}

dependencies {
  implementation(libs.google.material)
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
