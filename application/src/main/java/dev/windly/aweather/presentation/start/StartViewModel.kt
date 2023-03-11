package dev.windly.aweather.presentation.start

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.base.navigation.NavigationEvent
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.reactive.asFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
  resources: StartResources
) : ViewModel(), DefaultLifecycleObserver {

  private val navigationChannel: Channel<NavigationEvent> =
    Channel()

  val navigation: Flow<NavigationEvent> =
    navigationChannel.receiveAsFlow()

  private val helloFlow: Flow<CharSequence> =
    Flowable.just(resources.hello()).asFlow()

  val state: StateFlow<StartViewState> =
    helloFlow
      .map(::StartViewState)
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = StartViewState.empty()
      )
}
