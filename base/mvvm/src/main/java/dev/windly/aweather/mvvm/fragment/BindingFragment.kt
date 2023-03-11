package dev.windly.aweather.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<Binding : ViewDataBinding> : Fragment() {

  @get:LayoutRes
  abstract val layoutRes: Int

  protected open lateinit var binding: Binding

  abstract fun bindView(binding: Binding)

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View =
    inflate<Binding>(inflater, layoutRes, container, false)
      .also { binding = it }
      .also { it.lifecycleOwner = viewLifecycleOwner }
      .also(::bindView)
      .root
}
