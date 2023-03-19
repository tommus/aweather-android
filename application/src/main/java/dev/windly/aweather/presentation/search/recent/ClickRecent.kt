package dev.windly.aweather.presentation.search.recent

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import dev.windly.aweather.base.viewbinding.asBinding
import dev.windly.aweather.databinding.ItemRecentBinding
import dev.windly.aweather.geocoding.domain.model.Recent

class ClickRecent(private val listener: Listener) :
  ClickEventHook<RecentItem>() {

  override fun onBind(viewHolder: RecyclerView.ViewHolder): View? =
    viewHolder
      .asBinding<ItemRecentBinding>()
      ?.root

  override fun onClick(v: View,
    position: Int, fastAdapter: FastAdapter<RecentItem>, item: RecentItem) {

    listener.onRecentClicked(item.model)
  }

  interface Listener {

    /**
     * A callback that is invoked whenever user clicks
     * the [RecentItem].
     */
    fun onRecentClicked(recent: Recent)
  }
}
