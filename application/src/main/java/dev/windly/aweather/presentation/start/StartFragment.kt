package dev.windly.aweather.presentation.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.base.event.Event
import dev.windly.aweather.databinding.FragmentStartBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import dev.windly.aweather.presentation.start.StartEvent.NavigateToVisited
import dev.windly.aweather.presentation.start.StartEvent.NavigateToFresh
import javax.inject.Inject

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding, StartViewModel>() {

  @Inject lateinit var navigation: StartNavigation

  override val viewModel: StartViewModel
    by viewModels { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_start

  override fun bindView(binding: FragmentStartBinding) {
    // No-op.
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycle.addObserver(viewModel)

    lifecycleScope.launchWhenStarted {
      viewModel.navigation
        .collect(::handleNavigation)
    }
  }

  private fun handleNavigation(event: Event) {
    when (event) {
      is NavigateToVisited ->
        navigation.navigateToVisited(
          latitude = event.recent.latitude,
          longitude = event.recent.longitude,
        )
      is NavigateToFresh ->
        navigation.navigateToFresh()
    }
  }
}
