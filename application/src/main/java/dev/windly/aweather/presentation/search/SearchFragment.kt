package dev.windly.aweather.presentation.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentSearchBinding
import dev.windly.aweather.location.domain.model.Location
import dev.windly.aweather.mvvm.fragment.BaseFragment
import dev.windly.aweather.presentation.search.SearchEvent.NavigateWithLocation
import dev.windly.aweather.presentation.search.SearchEvent.NavigateWithRecent
import dev.windly.aweather.presentation.search.recent.ClickRecent
import dev.windly.aweather.presentation.search.result.ClickSearchResult
import dev.windly.aweather.recent.domain.model.Recent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment :
  BaseFragment<FragmentSearchBinding, SearchViewModel>(),
  ClickRecent.Listener, ClickSearchResult.Listener {

  @[Inject Search]
  lateinit var adapter: GenericFastItemAdapter

  @Inject lateinit var factory: SearchItemsFactory
  @Inject lateinit var navigation: SearchNavigation

  private val subscriptions = CompositeDisposable()

  override val viewModel: SearchViewModel
    by viewModels { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_search

  override fun bindView(binding: FragmentSearchBinding) {
    binding.viewModel = viewModel
    binding.resultsView.adapter = adapter
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycle.addObserver(viewModel)

    lifecycleScope.launchWhenStarted {
      viewModel.state
        .map(factory::create)
        .collect(::updateItems)
    }

    lifecycleScope.launchWhenStarted {
      viewModel.navigation.collect(::handleNavigation)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    subscriptions.clear()
  }

  override fun onRecentClicked(recent: Recent) {
    viewModel.onRecentClicked(recent)
  }

  override fun onSearchResultClicked(location: Location) {
    viewModel.onSearchResultClicked(location)
  }

  private fun updateItems(items: List<GenericItem>) {
    adapter.setNewList(items)
  }

  private fun handleNavigation(event: SearchEvent) {

    when (event) {
      is NavigateWithRecent ->
        navigation.navigateToForecast(
          latitude = event.recent.latitude,
          longitude = event.recent.longitude,
        )
      is NavigateWithLocation ->
        navigation.navigateToForecast(
          latitude = event.location.latitude,
          longitude = event.location.longitude,
        )
    }
  }
}
