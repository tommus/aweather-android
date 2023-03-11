package dev.windly.aweather.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

abstract class PrintVersionTask @Inject constructor(
  private val versionCode: Int,
  private val versionName: String
) : DefaultTask() {

  companion object {
    const val NAME = "printVersionData"
  }

  @TaskAction
  fun print() {
    println()
    println("---------- VERSION DATA ----------")
    println("-> CODE: $versionCode")
    println("-> NAME: $versionName")
    println("----------------------------------")
    println()
  }
}
