package dev.windly.aweather.weather.persistence.view

import androidx.room.Embedded
import androidx.room.Relation
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import dev.windly.aweather.weather.persistence.model.WeatherEntity

data class CurrentWeatherView(

  @Embedded
  val current: CurrentWeatherEntity = CurrentWeatherEntity(),

  @Relation(
    parentColumn = "id",
    entityColumn = "currentId"
  )
  val weather: List<WeatherEntity> = emptyList()
)
