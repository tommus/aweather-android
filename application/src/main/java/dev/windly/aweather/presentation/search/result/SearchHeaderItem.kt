package dev.windly.aweather.presentation.search.result

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import dev.windly.aweather.R
import dev.windly.aweather.databinding.ItemSearchHeaderBinding

class SearchHeaderItem : AbstractBindingItem<ItemSearchHeaderBinding>() {

  override val type: Int
    get() = R.id.itemSearchHeader

  override var identifier: Long =
    R.id.itemRecentHeader.toLong()

  override var isSelectable: Boolean =
    false

  override fun createBinding(
    inflater: LayoutInflater, parent: ViewGroup?): ItemSearchHeaderBinding =
    ItemSearchHeaderBinding.inflate(inflater, parent, false)
}
