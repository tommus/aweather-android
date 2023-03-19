package dev.windly.aweather.presentation.search

import androidx.fragment.app.Fragment
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import dev.windly.aweather.presentation.search.result.ClickSearchResult

@[Module InstallIn(FragmentComponent::class)]
object SearchModule {

  @[Provides FragmentScoped]
  internal fun fragment(source: Fragment): SearchFragment =
    source as SearchFragment

  @[Provides FragmentScoped]
  internal fun clickSearchResult(fragment: SearchFragment): ClickSearchResult =
    ClickSearchResult(listener = fragment)

  @[Provides FragmentScoped Search]
  internal fun adapter(
    clickSearchResults: ClickSearchResult
  ): GenericFastItemAdapter =
    GenericFastItemAdapter().also {
      it.eventHooks += clickSearchResults
    }
}
