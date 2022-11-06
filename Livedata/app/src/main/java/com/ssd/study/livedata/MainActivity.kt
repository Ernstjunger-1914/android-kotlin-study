package com.ssd.study.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 기본값은 0
    private var mutableLiveData = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            mutableLiveData.value = mutableLiveData.value!!.plus(1)
        }

        mutableLiveData.observe(this, Observer {
            Log.d(TAG, "mutableLiveData: ${mutableLiveData.value}")
            text.text = mutableLiveData.value.toString()
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}