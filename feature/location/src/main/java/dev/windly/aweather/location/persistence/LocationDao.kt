package dev.windly.aweather.location.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.windly.aweather.location.persistence.model.LocationEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface LocationDao {

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(entities: Iterable<LocationEntity>)

  @Query(value = """
    SELECT * FROM locations
    ORDER BY id ASC
  """)
  fun observeLocations(): Flowable<List<LocationEntity>>

  @Query(value = "DELETE FROM locations")
  fun deleteAll(): Completable
}
