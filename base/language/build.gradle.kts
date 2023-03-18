import dev.windly.aweather.ci.Build

plugins {
  id("kotlin")
  kotlin("kapt")
}

java {
  sourceCompatibility = Build.Version.java
  targetCompatibility = Build.Version.java
}

dependencies {

  api(libs.dagger)
  kapt(libs.dagger.compiler)

  api(libs.kotlin.stdlib)

  implementation(libs.jodatime)

  implementation(libs.rx.java)

  implementation(libs.mapstruct)
}
