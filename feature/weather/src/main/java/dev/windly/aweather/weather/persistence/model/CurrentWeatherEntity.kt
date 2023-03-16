package dev.windly.aweather.weather.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "forecasts",
  indices = [Index("name")],
)
data class CurrentWeatherEntity(

  // It's kind of funny that the documentation of [Embedded] annotation
  // showcases this exact use case of in-flattening the coordinates
  // wrapper class.

  @Embedded(prefix = "coordinate_")
  var coordinates: CoordEmbedded = CoordEmbedded(),

  // TODO: 16.03.2023 Design one-to-many relation.

  @Ignore
  var weather: List<WeatherEmbedded> = emptyList(),

  @ColumnInfo(name = "base")
  var base: String = "",

  @Embedded(prefix = "main_")
  var main: MainEmbedded = MainEmbedded(),

  @ColumnInfo(name = "visibility")
  var visibility: Int = 0,

  @Embedded(prefix = "wind_")
  var wind: WindEmbedded = WindEmbedded(),

  @Embedded(prefix = "clouds_")
  var clouds: CloudsEmbedded = CloudsEmbedded(),

  @Embedded(prefix = "rain_")
  var rain: FallEmbedded = FallEmbedded(),

  @Embedded(prefix = "snow_")
  var snow: FallEmbedded = FallEmbedded(),

  @ColumnInfo(name = "dt")
  var timestamp: Long = 0L,

  @Embedded(prefix = "sys_")
  var system: SysEmbedded = SysEmbedded(),

  @ColumnInfo(name = "timezone")
  var timezone: Long = 0L,

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0,

  @ColumnInfo(name = "name")
  var name: String = "",

  @ColumnInfo(name = "cod")
  var cod: Int = 0,
)
