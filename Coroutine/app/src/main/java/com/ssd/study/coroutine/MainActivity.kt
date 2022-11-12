package com.ssd.study.coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        run()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    private fun run() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "run() START")

            one()
            two()

            Log.d(TAG, "run() END")
        }
    }

    suspend fun one() {
        delay(500)
        Log.d(TAG, "one() 1")
        delay(500)
        Log.d(TAG, "one() 2")
    }

    suspend fun two() {
        delay(500)
        Log.d(TAG, "two() 1")
        delay(500)
        Log.d(TAG, "two() 2")
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}