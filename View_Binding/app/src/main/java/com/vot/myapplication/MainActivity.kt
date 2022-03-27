package com.vot.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vot.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * txtId1라는 id를 가진 Text View를 클릭하면 글자가 변경됨.
         */
        binding.txtId1.setOnClickListener {
            binding.txtId1.text="View Binding을 통해 text가 변경됨."
        }
    }
}