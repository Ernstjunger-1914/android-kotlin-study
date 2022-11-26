package com.ssd.mobile.android.study.workmanager.manager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerC(
    context: Context, workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        for (i in 1..10) {
            Thread.sleep(500)
            Log.d(TAG, i.toString())
        }
        return Result.success()
    }

    companion object {
        const val TAG: String = "WorkManagerC"
    }

}