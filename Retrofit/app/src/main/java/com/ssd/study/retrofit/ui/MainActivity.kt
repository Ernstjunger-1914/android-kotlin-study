package com.ssd.study.retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssd.study.retrofit.R
import com.ssd.study.retrofit.model.User

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getPostAll()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.getAllUser.observe(this, Observer {
            val viewHolder =
                MainViewHolder(it as ArrayList<User> /* = java.util.ArrayList<com.ssd.study.retrofit.model.User> */)

            recyclerView.adapter = viewHolder
            recyclerView.layoutManager = LinearLayoutManager(this)
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}