package dev.windly.aweather.presentation.search

import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentSearchBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

  @Inject lateinit var filter: SearchLocation

  override val viewModel: SearchViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_search

  override fun bindView(binding: FragmentSearchBinding) {
    // No-op.
  }
}
