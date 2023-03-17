package dev.windly.aweather.android.reactivex

import android.transition.Visibility
import android.view.View
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableSource
import io.reactivex.rxjava3.core.CompletableTransformer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 * A [CompletableTransformer] then emits the progress state of a given
 * [Completable] with which this transformer is being composed.
 *
 * Emission of [Visibility] is exposed via [progress] [StateFlow].
 */
class CompletableProgress(

  /**
   * Progress [Visibility] when the [Completable] is started.
   *
   * The default value is set to [View.VISIBLE].
   */
  private val onStart: Int = View.VISIBLE,

  /**
   * Progress [Visibility] when the [Completable] is finished.
   *
   * The default value is set to [View.GONE].
   */
  private val onFinished: Int = View.GONE

) : CompletableTransformer {

  private val _progress = MutableStateFlow(onFinished)

  /**
   * Current [Visibility] of the view associated with this
   * flow / stream.
   */
  val progress: StateFlow<Int> = _progress

  /**
   * Emits the [Visibility] change to the [progress] [StateFlow] so it's
   * collector can collect the state change.
   */
  override fun apply(upstream: Completable): CompletableSource =
    upstream
      .doOnSubscribe { _progress.value = onStart }
      .doFinally { _progress.value = onFinished }
}

