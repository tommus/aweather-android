package dev.windly.aweather.weather.utility

import dev.windly.aweather.weather.MeasurementUnit
import dev.windly.aweather.weather.SearchCriteria
import dev.windly.aweather.weather.domain.model.Coord
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrimmedCoordinates @Inject constructor(
  private val language: LocaleLanguage
) {

  private companion object {

    /**
     * Adds slight window for emission of reoccurring events.
     */
    private const val DELAY = 100L
  }

  // Oh boy, Weather API is dirty.
  //
  // While Geocoding microservice tends to return coordinates
  // with precision up to 6 decimal places, Weather microservice
  // trims it's precision down to 4 decimal places.
  //
  // It effectively prevents from implementing simple observation
  // stream in a persistence layer that uses coordinates as delivered
  // by geocoding microservice.

  private val processor: FlowableProcessor<Coord> =
    BehaviorProcessor.create()

  /**
   * Provides an information regarding the trimmed coordinates
   * delivered by weather microservice for the location found
   * by geocoding service.
   */
  private fun observe(): Flowable<Coord> =
    processor.onBackpressureLatest().hide()
      .throttleLast(DELAY, MILLISECONDS)

  /**
   * Emits a trimmed coordinates as a [SearchCriteria] that can be used
   * to observe a retrieved weather forecast.
   */
  fun observeAsCriteria(): Flowable<SearchCriteria> =
    observe().map { it.toSearchCriteria() }

  /**
   * A method that should be used to signal the trimmed coordinates
   * were retrieved.
   */
  fun accept(coordinates: Coord) {
    processor.onNext(coordinates)
  }

  private fun Coord.toSearchCriteria(): SearchCriteria =
    SearchCriteria(
      latitude = latitude,
      longitude = longitude,
      language = language.forMeasurements(),
      units = MeasurementUnit.METRIC,
    )
}
