package dev.windly.aweather.mvvm.databinding

import android.view.View
import androidx.databinding.BindingAdapter

interface ClickDataBinding {

  /**
   * Allows to register a click listener to any view. By default, all
   * clicks will be throttled using 1000 milliseconds window.
   */
  @BindingAdapter(
    requireAll = false,
    value = ["onThrottledClick", "throttleWindow"]
  )
  fun setOnThrottledClick(
    view: View, onThrottledClick: View.OnClickListener, throttleWindow: Long
  )

  /**
   * Allows to register a long click listener to any view.
   */
  @BindingAdapter(value = ["onLongClick"])
  fun setOnLongClick(view: View, onLongClick: View.OnClickListener)
}
