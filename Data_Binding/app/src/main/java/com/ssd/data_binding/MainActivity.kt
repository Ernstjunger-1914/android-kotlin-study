package com.ssd.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ssd.data_binding.databinding.ActivityMainBinding
import com.ssd.data_binding.model.Profile

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val profile = Profile("손소독", 222)
        binding.profile = profile
    }

    fun clickButton(view: View) {
        Log.d(TAG, "onClick")
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}