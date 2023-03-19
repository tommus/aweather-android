package dev.windly.aweather.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.reactive.asFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
  private val search: SearchLocation
) : ViewModel() {

  private val _results: StateFlow<SearchResults> =
    search
      .results().asFlow()
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = SearchResults.Empty
      )

  private val state: StateFlow<SearchState> =
    _results.map { SearchState.Empty }
      .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = SearchState.Empty
      )

  val location: MutableStateFlow<String> =
    MutableStateFlow(state.value.input)
}
