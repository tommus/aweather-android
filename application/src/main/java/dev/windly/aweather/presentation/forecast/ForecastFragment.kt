package dev.windly.aweather.presentation.forecast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.databinding.FragmentForecastBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import dev.windly.aweather.presentation.forecast.ForecastEvent.NavigateToFindLocation
import javax.inject.Inject

@AndroidEntryPoint
class ForecastFragment :
  BaseFragment<FragmentForecastBinding, ForecastViewModel>() {

  @Inject lateinit var navigation: ForecastNavigation

  override val viewModel: ForecastViewModel
    by viewModels { defaultViewModelProviderFactory }

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
      is NavigateToFindLocation ->
        navigation.navigateToFindLocation()
    }
  }
}
