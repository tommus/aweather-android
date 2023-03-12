package dev.windly.aweather.presentation.search

import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentSearchBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

  override val viewModel: SearchViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_forecast

  override fun bindView(binding: FragmentSearchBinding) {
    // No-op.
  }
}
