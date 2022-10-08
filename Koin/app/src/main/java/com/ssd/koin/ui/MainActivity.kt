package com.ssd.koin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ssd.koin.R
import com.ssd.koin.module.Asdf
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    // inject 의존성 주입 - by lazy 방식
    val asdf_inject1: Asdf by inject()
    val asdf_inject2 by inject<Asdf>()

    // get 의존성 주입 - 바로 주입
    val asdf_get1: Asdf = get()
    val asdf_get2 = get<Asdf>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "asdf_inject1: ${asdf_inject1.name()}")
        Log.d(TAG, "asdf_inject2: ${asdf_inject2.name()}")
        Log.d(TAG, "asdf_get1: ${asdf_get1.name()}")
        Log.d(TAG, "asdf_get2: ${asdf_get2.name()}")
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}