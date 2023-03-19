package dev.windly.aweather.presentation.search.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import dev.windly.aweather.R
import dev.windly.aweather.databinding.ItemRecentHeaderBinding

class RecentHeaderItem : AbstractBindingItem<ItemRecentHeaderBinding>() {

  override val type: Int
    get() = R.id.itemRecentHeader

  override var identifier: Long =
    R.id.itemRecentHeader.toLong()

  override var isSelectable: Boolean =
    false

  override fun createBinding(
    inflater: LayoutInflater, parent: ViewGroup?): ItemRecentHeaderBinding =
    ItemRecentHeaderBinding.inflate(inflater, parent, false)
}
