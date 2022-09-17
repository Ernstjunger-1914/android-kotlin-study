package com.ssd.viewmodel2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = fragmentManager.beginTransaction()
        val fragment = MainFragment()

        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}