package dev.windly.aweather.presentation.start

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.windly.aweather.R
import dev.windly.aweather.base.navigation.Event
import dev.windly.aweather.databinding.FragmentStartBinding
import dev.windly.aweather.mvvm.fragment.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding, StartViewModel>() {

  @Inject lateinit var navigation: StartNavigation

  override val viewModel: StartViewModel
    by navGraphViewModels(R.id.nav_main) { defaultViewModelProviderFactory }

  override val layoutRes: Int
    get() = R.layout.fragment_start

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycle.addObserver(viewModel)

    lifecycleScope.launchWhenCreated {
      viewModel.state.collect(::show)
    }

    lifecycleScope.launchWhenStarted {
      viewModel.navigation
        .collect(::handleNavigation)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    lifecycle.removeObserver(viewModel)
  }

  override fun bindView(binding: FragmentStartBinding) {
    // No-op.
  }

  private fun show(state: StartViewState) {
    binding.hello = state.data
  }

  private fun handleNavigation(event: Event) {
    when (event) {

      // TODO: Consume navigation event.
      is StartEvent -> Unit
    }
  }
}
