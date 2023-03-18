package dev.windly.aweather.presentation.forecast

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentForecastBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class ForecastFragment :
  BaseFragment<FragmentForecastBinding, ForecastViewModel>() {

  @Inject lateinit var navigation: ForecastNavigation

  override val viewModel: ForecastViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_forecast

  override fun bindView(binding: FragmentForecastBinding) {
    binding.viewModel = viewModel
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycle.addObserver(viewModel)

    lifecycleScope.launchWhenStarted {
      viewModel.navigation.collect(::handleNavigation)
    }
  }

  private fun handleNavigation(event: ForecastEvent) {
    when (event) {
      ForecastEvent.NavigateToFindLocation ->
        navigation.navigateToFindLocation()
    }
  }
}
