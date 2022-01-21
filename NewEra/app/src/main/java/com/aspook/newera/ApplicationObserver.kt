package com.aspook.newera

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.d("TAG", "onForeground!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.d("TAG", "onBackground!");
    }
}