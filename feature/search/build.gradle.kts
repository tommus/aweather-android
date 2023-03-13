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

  namespace = "$packageName.search"

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
  implementation(project(":base:android"))

  implementation(libs.bundles.androidx.room)
  kapt(libs.androidx.room.compiler)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.mapstruct)
  kapt(libs.mapstruct.processor)

  implementation(libs.moshi)
  kapt(libs.moshi.codegen)

  implementation(libs.bundles.retrofit)

  implementation(libs.windly.limbo.mapstruct)
}
