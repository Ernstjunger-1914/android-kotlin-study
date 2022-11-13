package com.ssd.study.retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ssd.study.retrofit.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getUser1()
        viewModel.getUserNumber(4)

        val text1 = findViewById<TextView>(R.id.textView1)
        val text2 = findViewById<TextView>(R.id.textView2)

        viewModel.getUser1.observe(this, Observer {
            text1.text = it.toString()
        })
        viewModel.getUser2.observe(this, Observer {
            text2.text = it.toString()
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}