package com.ssd.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssd.recyclerview.adapter.CustomDataAdapter
import com.ssd.recyclerview.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        val arr = ArrayList<String>()

        arr.add("ㄱ")
        arr.add("ㄴ")
        arr.add("ㄷ")
        arr.add("ㄹ")
        arr.add("ㅁ")
        arr.add("ㅂ")
        arr.add("ㅅ")
        arr.add("ㅇ")
        arr.add("ㅈ")
        arr.add("ㅊ")
        arr.add("ㅋ")
        arr.add("ㅌ")
        arr.add("ㅍ")
        arr.add("ㅎ")

        val customDataAdapter = CustomDataAdapter(arr)
        val recyclerView = binding.recyclerView

        recyclerView.adapter = customDataAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}