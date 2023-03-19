package dev.windly.aweather.geocoding.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.windly.aweather.geocoding.persistence.model.RecentEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface RecentDao {

  @WorkerThread
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(entity: RecentEntity)

  @Query(value = """
    SELECT * FROM recents
    WHERE input LIKE :input || '%'
    ORDER BY id DESC
    LIMIT 5
  """)
  fun observeLastFive(input: String): Flowable<List<RecentEntity>>

  @Query(value = "DELETE FROM recents")
  fun deleteAll(): Completable
}
