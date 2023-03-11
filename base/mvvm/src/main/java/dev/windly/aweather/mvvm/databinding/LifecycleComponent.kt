package dev.windly.aweather.mvvm.databinding

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import java.util.concurrent.TimeUnit.MILLISECONDS

class LifecycleComponent(private val lifecycle: Lifecycle) :
  ClickDataBinding,
  DataBindingComponent,
  DefaultLifecycleObserver {

  private val disposables: CompositeDisposable = CompositeDisposable()

  init {
    lifecycle.addObserver(this)
  }

  override fun onDestroy(owner: LifecycleOwner) {
    super.onDestroy(owner)
    disposables.clear()
    lifecycle.removeObserver(this)
  }

  override fun setOnThrottledClick(view: View, onThrottledClick: OnClickListener,
    throttleWindow: Long) {

    val windowDuration = when (throttleWindow == 0L) {
      true -> 1_000L
      false -> throttleWindow
    }

    disposables += view.clicks()
      .throttleFirst(windowDuration, MILLISECONDS)
      .subscribe { onThrottledClick.onClick(view) }
  }

  override fun setOnLongClick(view: View, onLongClick: OnClickListener) {
    TODO("Not yet implemented")
  }

  override fun getClickDataBinding(): ClickDataBinding =
    this
}
