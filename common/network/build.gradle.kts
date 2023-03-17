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

  implementation(libs.dagger.hilt.android)
  kapt(libs.dagger.hilt.compiler)

  implementation(libs.moshi)
  kapt(libs.moshi.codegen)

  implementation(libs.okhttp)
  implementation(libs.okhttp.logging)

  api(libs.bundles.retrofit)
  implementation(libs.retrofit.rxjava3)
}
