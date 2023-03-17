package dev.windly.aweather.weather.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import dev.windly.aweather.weather.persistence.model.WeatherEntity
import dev.windly.aweather.weather.persistence.view.CurrentWeatherView
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
abstract class CurrentWeatherDao {

  @Transaction
  open fun insert(
    forecast: CurrentWeatherEntity,
    descriptions: Iterable<WeatherEntity>
  ) /* : Unit */ {

    insert(forecast)

    // Find referenced items that should be removed as they might no
    // longer be available.
    val ids = descriptions.map(WeatherEntity::id).toSet()

    deleteReferenced(ids)

    // Add recently received referenced items.
    insertReferenced(descriptions)
  }

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insert(entity: CurrentWeatherEntity) // : Unit

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insertReferenced(entities: Iterable<WeatherEntity>) // : Unit

  @Transaction
  @Query(value = """
    SELECT * FROM forecasts
    WHERE coordinate_latitude = :latitude 
      AND coordinate_longitude = :longitude
    LIMIT 1
  """)
  abstract fun observeWeather(
    latitude: Float,
    longitude: Float
  ): Flowable<CurrentWeatherView>

  @Query(value = "DELETE FROM forecasts")
  abstract fun deleteAll(): Completable

  @Query(value = "DELETE FROM weather_descriptions WHERE id NOT IN (:ids)")
  abstract fun deleteReferenced(ids: Set<Long>) // : Unit
}
