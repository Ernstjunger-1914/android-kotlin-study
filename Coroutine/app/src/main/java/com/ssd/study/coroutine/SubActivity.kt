package com.ssd.study.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class SubActivity : AppCompatActivity() {

    lateinit var viewModel: SubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        viewModel = ViewModelProvider(this)[SubViewModel::class.java]
        viewModel.one()
        viewModel.two()
    }

    companion object {
        const val TAG: String = "SubActivity"
    }

}