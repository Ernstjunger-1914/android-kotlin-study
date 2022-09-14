package com.ssd.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // view Model 가져오기
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        Log.d(TAG, "onCreate()")

        val plusButton: Button = findViewById(R.id.plusButton)
        val minusButton: Button = findViewById(R.id.minusButton)
        val resultNumber: TextView = findViewById(R.id.number)

        resultNumber.text = mainViewModel.countNumber.toString()

        // plusButton 클릭 시 countNumber에 1을 더 해주고 resultNumber TextView에 증가된 값을 보여준다.
        plusButton.setOnClickListener {
            mainViewModel.plus()

            resultNumber.text = mainViewModel.countNumber.toString()
        }

        minusButton.setOnClickListener {
            mainViewModel.minus()

            resultNumber.text = mainViewModel.countNumber.toString()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy()")
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}