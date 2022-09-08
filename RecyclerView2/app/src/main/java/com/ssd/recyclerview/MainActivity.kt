package com.ssd.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssd.recyclerview.adapter.CustomAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val customAdapter = CustomAdapter(arr)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}