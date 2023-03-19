package dev.windly.aweather.presentation.search.result

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.ModelAbstractBindingItem
import dev.windly.aweather.R
import dev.windly.aweather.databinding.ItemSearchResultBinding
import dev.windly.aweather.location.domain.model.Location

class SearchResultItem(location: Location) :
  ModelAbstractBindingItem<Location, ItemSearchResultBinding>(location) {

  private var name: CharSequence? = null
  private var details: CharSequence? = null

  override val type: Int
    get() = R.id.itemSearchResult

  init {
    identifier = location.id
  }

  override fun createBinding(
    inflater: LayoutInflater, parent: ViewGroup?): ItemSearchResultBinding =
    ItemSearchResultBinding.inflate(inflater, parent, false)

  override fun bindView(binding: ItemSearchResultBinding, payloads: List<Any>) {
    super.bindView(binding, payloads)
    binding.name = name
    binding.details = details
  }

  override fun unbindView(binding: ItemSearchResultBinding) {
    super.unbindView(binding)
    binding.name = null
    binding.details = null
  }

  fun withName(value: CharSequence): SearchResultItem =
    apply { name = value }

  fun withDetails(value: CharSequence?): SearchResultItem =
    apply { details = value }
}
