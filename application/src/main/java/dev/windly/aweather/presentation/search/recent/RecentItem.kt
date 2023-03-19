package dev.windly.aweather.presentation.search.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.ModelAbstractBindingItem
import dev.windly.aweather.R
import dev.windly.aweather.databinding.ItemRecentBinding
import dev.windly.aweather.recent.domain.model.Recent

class RecentItem(recent: Recent) :
  ModelAbstractBindingItem<Recent, ItemRecentBinding>(recent) {

  private var name: CharSequence? = null

  override val type: Int
    get() = R.id.itemRecent

  init {
    identifier = recent.id
  }

  override fun createBinding(
    inflater: LayoutInflater, parent: ViewGroup?): ItemRecentBinding =
    ItemRecentBinding.inflate(inflater, parent, false)

  override fun bindView(binding: ItemRecentBinding, payloads: List<Any>) {
    super.bindView(binding, payloads)
    binding.name = name
  }

  override fun unbindView(binding: ItemRecentBinding) {
    super.unbindView(binding)
    binding.name = null
  }

  fun withName(value: CharSequence): RecentItem =
    apply { name = value }
}
