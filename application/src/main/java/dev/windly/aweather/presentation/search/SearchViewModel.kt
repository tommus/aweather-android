package dev.windly.aweather.presentation.search

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.windly.aweather.geocoding.domain.model.Location
import dev.windly.aweather.presentation.search.SearchEvent.NavigateToForecast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactive.asFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
  private val factory: SearchStateFactory,
  private val search: SearchLocation
) : ViewModel(), DefaultLifecycleObserver {

  private val _navigation = Channel<SearchEvent>()

  internal val navigation: Flow<SearchEvent> =
    _navigation.receiveAsFlow()

  val input: MutableStateFlow<String> =
    MutableStateFlow("")

  private val _results: StateFlow<SearchResults> =
    search
      .results().asFlow()
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = SearchResults.Empty
      )

  val state: StateFlow<SearchState> =
    combine(input, _results, factory::create)
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = SearchState.Empty
      )

  internal fun onSearchResultClicked(location: Location) {
    viewModelScope.launch {
      _navigation.send(NavigateToForecast(location))
    }
  }

  init {
    viewModelScope.launch {
      input.collect(search::onInput)
    }
  }
}
