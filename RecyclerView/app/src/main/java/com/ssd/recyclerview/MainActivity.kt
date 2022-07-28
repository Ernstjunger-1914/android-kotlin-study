package com.ssd.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userList = arrayListOf<UserData>(
        UserData("소독", "sd123", "지구 어딘가", "ㅎㅇ", "profile_image_01"),
        UserData("손소독", "ssd1234", "손소독제 제조 공장", "안녕하세요", "profile_image_02"),
        UserData("홍길동", "hgd", "조선 어딘가", "hi", "profile_image_03"),
        UserData("홍길서", "hgleft", "???", "bye world", "profile_image_04"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CustomAdapter(this, userList)
        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }

}