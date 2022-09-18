package com.vot.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// AndroidEntryPoint 어노테이션은 종속항목 삽입
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    @ActivityModule
    @Inject
    lateinit var dataStateListener: OnDataStateListener

    @Inject
    lateinit var dataStateListenerImpl: DataStateListenerImpl

    @Inject
    lateinit var dataModel1: DataModel

    @Inject
    lateinit var dataModel2: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataModel1.message = "손소독"
        Log.d(TAG, dataModel1.message)
        Log.d(TAG, dataModel2.message)
        dataStateListenerImpl.state("success")
    }
}