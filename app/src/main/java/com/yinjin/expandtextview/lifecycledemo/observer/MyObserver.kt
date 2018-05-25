package com.yinjin.expandtextview.lifecycledemo.observer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.Log
import org.jetbrains.anko.toast

/**
 * desc:
 * time: 2018/5/25
 * @author yinYin
 */
class MyObserver(context: Context): LifecycleObserver {
    val contextObserver:Context=context
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.e("TAG","onCreate")
        contextObserver.toast("onCreate")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.e("TAG","onStart")
        contextObserver.toast("onStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.e("TAG","onPause")
        contextObserver.toast("onPause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.e("TAG","onStop")
        contextObserver.toast("onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.e("TAG","onDestroy")
        contextObserver.toast("onDestroy")
    }

}