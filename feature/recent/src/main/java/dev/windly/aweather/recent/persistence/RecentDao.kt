package dev.windly.aweather.recent.persistence

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.windly.aweather.recent.persistence.model.RecentEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

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

  @Query(value = """
    SELECT * FROM recents 
    ORDER BY id DESC 
    LIMIT 1
  """)
  fun retrieveLatest(): Single<RecentEntity>

  @Query(value = "SELECT COUNT(id) > 0 FROM recents")
  fun isNotEmpty(): Single<Boolean>

  @Query(value = "DELETE FROM recents")
  fun deleteAll(): Completable
}
