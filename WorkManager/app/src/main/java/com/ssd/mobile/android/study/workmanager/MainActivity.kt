package com.ssd.mobile.android.study.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.ssd.mobile.android.study.workmanager.manager.WorManagerB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: Data = workDataOf(
            "a" to 10,
            "b" to 20
        )
        val workManagerB = OneTimeWorkRequestBuilder<WorManagerB>().setInputData(data).build()

        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->
                if(info!=null&&info.state.isFinished) {
                    val result = info.outputData.getInt("result", 10000)
                    val result2 = info.outputData.getInt("result2", 10000)

                    Log.d(TAG, result.toString())
                    Log.d(TAG, result2.toString())
                }
            })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}