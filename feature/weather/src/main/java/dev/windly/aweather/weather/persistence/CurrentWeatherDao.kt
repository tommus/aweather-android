package dev.windly.aweather.weather.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface CurrentWeatherDao {

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(entity: CurrentWeatherEntity)

  @Query(value = """
    SELECT * FROM forecasts
    WHERE coordinate_latitude = :latitude 
      AND coordinate_longitude = :longitude
    LIMIT 1
  """)
  fun observeWeather(
    latitude: Float,
    longitude: Float
  ): Flowable<CurrentWeatherEntity>

  @Query(value = "DELETE FROM forecasts")
  fun deleteAll(): Completable
}
