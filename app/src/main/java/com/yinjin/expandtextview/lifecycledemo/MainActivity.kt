package com.yinjin.expandtextview.lifecycledemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yinjin.expandtextview.lifecycledemo.observer.MyObserver
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val myObserver: MyObserver by lazy {
        MyObserver(this)
    }

    lateinit var viewModel: MyViewMoudle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyViewMoudle::class.java)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(myObserver)
        observer()
        setValue()
    }

    private fun setValue() {
        doAsync {
            for (i in 0 until 20) {
                Thread.sleep(1000)
                runOnUiThread {
                    viewModel.name.value = (i + 20).toString().takeIf { it != "28" } ?: "這個是28的數據"
                }
            }
        }

    }

    private fun observer() {
        viewModel.name.observe(this, Observer<String> {
            tv1.text = it ?: ""
        })
    }

}

class MyViewMoudle : ViewModel() {
    var name = MutableLiveData<String>()
}
