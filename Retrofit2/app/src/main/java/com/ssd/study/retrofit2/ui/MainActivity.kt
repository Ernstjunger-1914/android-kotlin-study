package com.ssd.study.retrofit2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssd.study.retrofit2.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllPlants()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.getAllPlants.observe(this, Observer {
            val adapter = MainViewHolder(this, it)

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}