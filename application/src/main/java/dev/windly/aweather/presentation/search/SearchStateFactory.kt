package dev.windly.aweather.presentation.search

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SearchStateFactory @Inject constructor() {

  internal fun create(
    input: String,
    results: SearchResults,
  ): SearchState =
    SearchState(
      input = input,
      valid = results.valid,
      recent = results.recent,
      results = results.locations,
    )
}
