package dev.windly.aweather.base.viewbinding

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.mikepenz.fastadapter.binding.BindingViewHolder

/**
 * Casts [view holder][RecyclerView.ViewHolder] instance to expected
 * [view binding][ViewBinding] type.
 *
 * In case if given view holder does not match expected type,
 * it returns null.
 */
inline fun <reified T : ViewBinding> RecyclerView.ViewHolder.asBinding(): T? =
  when (this is BindingViewHolder<*> && binding is T) {
    true -> binding as T
    false -> null
  }
