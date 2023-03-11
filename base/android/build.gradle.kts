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

  namespace = "$packageName.android"

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

  implementation(project(":base:language"))
  implementation(project(":configuration"))

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  api(libs.timber)
}
