@file:Suppress("UnstableApiUsage")

import dev.windly.aweather.ci.Application.packageName
import dev.windly.aweather.ci.Build
import dev.windly.aweather.ci.Build.Android
import dev.windly.aweather.ci.Build.Version
import dev.windly.aweather.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "$packageName.network"

  buildFeatures {
    buildConfig = false
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

  implementation(project(":base:language"))
  implementation(project(":configuration"))

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.network.moshi)
  kapt(libs.network.moshi.codegen)

  implementation(libs.network.okhttp)
  implementation(libs.network.okhttp.logging)

  api(libs.bundles.network.retrofit)
  implementation(libs.network.retrofit.rxjava3)
}
