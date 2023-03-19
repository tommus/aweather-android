package dev.windly.aweather.presentation.search.placeholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import dev.windly.aweather.R
import dev.windly.aweather.databinding.ItemPlaceholderBinding

class PlaceholderItem : AbstractBindingItem<ItemPlaceholderBinding>() {

  override val type: Int
    get() = R.id.itemPlacholder

  override var identifier: Long =
    R.id.itemPlacholder.toLong()

  override var isSelectable: Boolean =
    false

  override fun createBinding(
    inflater: LayoutInflater, parent: ViewGroup?): ItemPlaceholderBinding =
    ItemPlaceholderBinding.inflate(inflater, parent, false)
}
