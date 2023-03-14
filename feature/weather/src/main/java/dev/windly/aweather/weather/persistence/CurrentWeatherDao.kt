package dev.windly.aweather.weather.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.windly.aweather.weather.persistence.model.CurrentWeatherEntity
import io.reactivex.rxjava3.core.Completable

@Dao
interface CurrentWeatherDao {

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(entities: Iterable<CurrentWeatherEntity>)

  // TODO: 14.03.2023 Add observation streams.

  @Query(value = "DELETE FROM forecasts")
  fun deleteAll(): Completable
}
