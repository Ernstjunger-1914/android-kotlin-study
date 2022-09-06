package com.ssd.tab_layout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssd.tab_layout.R
import com.ssd.tab_layout.adapter.PagerAdapter
import com.ssd.tab_layout.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        viewPager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewPager_main)
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}