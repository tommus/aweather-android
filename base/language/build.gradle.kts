plugins {
  id("kotlin")
  kotlin("kapt")
}

dependencies {
  api(libs.kotlin.stdlib)
  implementation(libs.rx.java)
  implementation(libs.mapstruct)
}
