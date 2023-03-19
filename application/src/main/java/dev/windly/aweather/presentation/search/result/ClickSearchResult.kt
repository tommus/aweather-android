package dev.windly.aweather.presentation.search.result

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import dev.windly.aweather.base.viewbinding.asBinding
import dev.windly.aweather.databinding.ItemSearchResultBinding
import dev.windly.aweather.geocoding.domain.model.Location

class ClickSearchResult(private val listener: Listener) :
  ClickEventHook<SearchResultItem>() {

  override fun onBind(viewHolder: RecyclerView.ViewHolder): View? =
    viewHolder
      .asBinding<ItemSearchResultBinding>()
      ?.root

  override fun onClick(v: View,
    position: Int, fastAdapter: FastAdapter<SearchResultItem>,
    item: SearchResultItem) {

    listener.onSearchResultClicked(item.model)
  }

  interface Listener {

    /**
     * A callback that is invoked whenever user clicks
     * the [SearchResultItem].
     */
    fun onSearchResultClicked(location: Location)
  }
}
