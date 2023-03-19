package dev.windly.aweather.reactive

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableObserver

class RxCompletableObserver private constructor(
  private var onError: ((error: Throwable) -> Unit)? = null,
  private var onComplete: (() -> Unit)? = null
) : DisposableCompletableObserver() {

  companion object {

    /**
     * Creates a [DisposableObserver].
     */
    fun create(): RxCompletableObserver =
      RxCompletableObserver()
  }

  /**
   * Adds [onError] implementation for the [DisposableObserver].
   */
  fun withOnError(
    onError: (error: Throwable) -> Unit
  ): RxCompletableObserver = apply { this.onError = onError }

  /**
   * Adds [onComplete] implementation for the [DisposableObserver].
   */
  fun withOnComplete(
    onComplete: () -> Unit
  ): RxCompletableObserver = apply { this.onComplete = onComplete }

  /**
   * Notifies the [DisposableObserver] that the [Observable] has experienced
   * an error condition.
   *
   * If the [Observable] call this method, it will not thereafter call
   * [onComplete].
   */
  override fun onError(error: Throwable) {
    onError?.invoke(error)
  }

  /**
   * Notifies the [DisposableObserver] that the [Observable] has finished
   * sending push-based notifications.
   *
   * The [Observable] will not call this method if it calls [onError].
   */
  override fun onComplete() {
    onComplete?.invoke()
  }
}
