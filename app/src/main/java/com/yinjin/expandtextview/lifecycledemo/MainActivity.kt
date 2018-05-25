package com.yinjin.expandtextview.lifecycledemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yinjin.expandtextview.lifecycledemo.observer.MyObserver

class MainActivity : AppCompatActivity() {
    val myObserver: MyObserver by lazy {
        MyObserver(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(myObserver)
    }

}
