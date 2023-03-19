package dev.windly.aweather.presentation.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentSearchBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

  @[Inject Search]
  lateinit var adapter: GenericFastItemAdapter

  @Inject lateinit var factory: SearchItemsFactory

  private val subscriptions = CompositeDisposable()

  override val viewModel: SearchViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

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
  }

  override fun onDestroyView() {
    super.onDestroyView()
    subscriptions.clear()
  }

  private fun updateItems(items: List<GenericItem>) {
    adapter.setNewList(items)
  }
}
