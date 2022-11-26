package com.ssd.mobile.android.study.workmanager.manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class WorkManagerC(
    context: Context, workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        withContext(Dispatchers.IO) {
            count1()
            count2()
        }

        return Result.success()
    }

    private suspend fun count1() {
        for (i in 1..10) {
            delay(100)
            Log.d(TAG, "count1: $i")
        }
    }

    private suspend fun count2() {
        for (i in 1..10) {
            val result = workDataOf(PROGRESS to i * 10)
            setProgress(result)
            delay(100)
            //            Log.d(TAG, "count2: $i")
        }
    }

    companion object {
        const val TAG: String = "WorkManagerC"
        const val PROGRESS: String = "progress"
    }

}