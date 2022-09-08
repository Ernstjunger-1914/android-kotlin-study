package com.ssd.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssd.recyclerview.adapter.CustomViewAdapter
import com.ssd.recyclerview.databinding.ActivityMainBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val arr = ArrayList<String>()

        arr.add("A")
        arr.add("B")
        arr.add("C")
        arr.add("D")
        arr.add("E")
        arr.add("F")
        arr.add("G")
        arr.add("H")
        arr.add("I")
        arr.add("J")
        arr.add("K")
        arr.add("L")
        arr.add("M")
        arr.add("M")
        arr.add("N")
        arr.add("O")
        arr.add("P")

        val customViewAdapter = CustomViewAdapter(arr)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = customViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}