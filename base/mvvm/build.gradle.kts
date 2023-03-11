@file:Suppress("UnstableApiUsage")

import dev.windly.aweather.ci.Application.packageName
import dev.windly.aweather.ci.Build.Android
import dev.windly.aweather.ci.Build.Version
import dev.windly.aweather.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "$packageName.mvvm"

  buildFeatures {
    dataBinding = true
  }

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    consumerProguardFiles(CONSUMER)
    minSdk = Android.minSdk
  }
}

dependencies {
  implementation(libs.androidx.fragment)
  implementation(libs.rx.binding)
  implementation(libs.rx.java)
  implementation(libs.rx.kotlin)
}
