package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ViewModelScoped
import dev.windly.aweather.geocoding.GeocodingRepository
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.geocoding.domain.model.Recent
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

@ViewModelScoped
class StoreRecentLocation @Inject constructor(
  private val repository: GeocodingRepository,
  private val search: SearchLocation
) {

  /**
   * Persists selected location as a [recently used location][Recent].
   */
  fun save(location: Location): Completable =
    search.input()
      .map { toRecent(input = it, location = location) }
      .flatMapCompletable(repository::saveRecent)

  /**
   * Creates [Recent] from given [input] text and [Location].
   */
  private fun toRecent(input: String, location: Location): Recent =
    Recent(
      input = input,
      name = location.name,
      latitude = location.latitude,
      longitude = location.longitude,
    )
}
