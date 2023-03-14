package dev.windly.aweather.presentation.forecast

import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentForecastBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment

@AndroidEntryPoint
class ForecastFragment : BaseFragment<FragmentForecastBinding, ForecastViewModel>() {

  override val viewModel: ForecastViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_forecast

  override fun bindView(binding: FragmentForecastBinding) {
    // No-op.
  }
}