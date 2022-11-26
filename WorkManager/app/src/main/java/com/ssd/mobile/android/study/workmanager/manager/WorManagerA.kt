package com.ssd.mobile.android.study.workmanager.manager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep
import java.text.SimpleDateFormat
import java.util.*

class WorManagerA(
    context: Context, workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d(TAG, "doWork()")

        val format = SimpleDateFormat("hh:mm:ss")
        val currentTime = format.format(Date())

        Log.d(TAG, currentTime)

        return Result.success()
    }

    companion object {
        const val TAG = "WorManagerA"
    }

}