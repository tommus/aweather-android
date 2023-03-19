package dev.windly.aweather.presentation.search

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactive.asFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
  private val factory: SearchStateFactory,
  private val search: SearchLocation
) : ViewModel(), DefaultLifecycleObserver {

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

  init {
    viewModelScope.launch {
      input.collect(search::onInput)
    }
  }
}
