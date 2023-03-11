import dev.windly.aweather.ci.Build
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath(libs.bundles.gradle.plugins)
  }
}

subprojects {
  tasks.withType<KotlinCompile>().all {
    kotlinOptions {
      jvmTarget = Build.Version.kotlin
    }
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
