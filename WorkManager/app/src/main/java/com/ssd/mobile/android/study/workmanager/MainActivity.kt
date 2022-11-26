package com.ssd.mobile.android.study.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.*
import com.ssd.mobile.android.study.workmanager.manager.WorManagerA
import com.ssd.mobile.android.study.workmanager.manager.WorManagerB
import com.ssd.mobile.android.study.workmanager.manager.WorkManagerC
import com.ssd.mobile.android.study.workmanager.manager.WorkManagerC.Companion.PROGRESS
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val data: Data = workDataOf(
//            "a" to 10,
//            "b" to 20
//        )

//        val workManagerA = OneTimeWorkRequestBuilder<WorManagerA>().build()

        // 1분 마다 작업 실행
        val workManagerA = PeriodicWorkRequestBuilder<WorManagerA>(1, TimeUnit.MINUTES).build()
//        val workManagerB = OneTimeWorkRequestBuilder<WorManagerB>().setInputData(data).build()
        val workManagerB = OneTimeWorkRequestBuilder<WorManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

        WorkManager.getInstance(this).enqueue(workManagerA)

//        WorkManager.getInstance(this)
//            .beginWith(listOf(workManagerA, workManagerB))
//            .then(workManagerC)
//            .enqueue()

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerC.id)
            .observe(this, Observer { workInfo: WorkInfo? ->
                val process = workInfo?.progress
                val value = process?.getInt(PROGRESS, 0)

                if (value != 0) Log.d(TAG, "${value.toString()}%")


                if (value == 100) Log.d(TAG, "END")
            })

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
//            .observe(this, Observer { info ->
//                if (info != null && info.state.isFinished) {
//                    val result = info.outputData.getInt("result", 10000)
//                    val result2 = info.outputData.getInt("result2", 10000)
//
//                    Log.d(TAG, result.toString())
//                    Log.d(TAG, result2.toString())
//                }
//            })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}