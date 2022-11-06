package com.ssd.study.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        button.setOnClickListener {
            viewModel.addLiveDataValue()
        }

        viewModel.mutableLiveData.observe(this, Observer {
            text.text = viewModel.mutableLiveData.value.toString()
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}