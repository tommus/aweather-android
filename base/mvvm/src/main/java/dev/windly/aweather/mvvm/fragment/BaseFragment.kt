package dev.windly.aweather.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dev.windly.aweather.mvvm.databinding.LifecycleComponent

abstract class BaseFragment<Binding : ViewDataBinding, VM : ViewModel> :
  BindingFragment<Binding>() {

  abstract val viewModel: VM

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View {
    DataBindingUtil.setDefaultComponent(LifecycleComponent(lifecycle))
    return super.onCreateView(inflater, container, savedInstanceState)
  }
}
