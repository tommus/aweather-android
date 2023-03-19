package dev.windly.aweather.presentation.start

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.presentation.start.StartEvent.NavigateToVisited
import dev.windly.aweather.presentation.start.StartEvent.NavigateToFresh
import dev.windly.aweather.recent.RecentRepository
import dev.windly.aweather.recent.domain.model.Recent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
  private val recent: RecentRepository
) : ViewModel(), DefaultLifecycleObserver {

  private val subscriptions = CompositeDisposable()

  private val _navigation = Channel<StartEvent>()

  /**
   * Asynchronously emits events that relates to the navigation
   * between the screens.
   *
   * Observer of this stream should subscribe to this flow and
   * perform navigation operations on behalf of the user.
   */
  internal val navigation: Flow<StartEvent> =
    _navigation.receiveAsFlow()

  override fun onCreate(owner: LifecycleOwner) {
    super.onCreate(owner)
    checkIfHasRecent()
  }

  override fun onDestroy(owner: LifecycleOwner) {
    super.onDestroy(owner)
    subscriptions.clear()
  }

  private fun checkIfHasRecent() {

    val disposable =
      recent.isNotEmpty()
        .subscribe(::onRecentStatus, ::onRecentError)

    subscriptions.add(disposable)
  }

  private fun onRecentStatus(contains: Boolean) {

    if (!contains) {
      viewModelScope.launch {
        _navigation.send(NavigateToFresh)
      }
      return
    }

    loadLatestRecent()
  }

  private fun onRecentError(throwable: Throwable) {
    Timber.e(
      message = "An error occurred while checking recent status.",
      throwable
    )
  }

  private fun loadLatestRecent() {

    val disposable =
      recent.retrieveLatest()
        .subscribe(::onLatestRecent, ::onLatestError)

    subscriptions.add(disposable)
  }

  private fun onLatestRecent(recent: Recent) {
    viewModelScope.launch {
      _navigation.send(NavigateToVisited(recent))
    }
  }

  private fun onLatestError(throwable: Throwable) {
    Timber.e(
      message = "An error occurred while loading latest recent.",
      throwable
    )
  }
}
