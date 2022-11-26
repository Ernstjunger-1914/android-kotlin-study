package com.ssd.mobile.android.study.workmanager.manager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorManagerB(
    context: Context, workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d(TAG, a.toString())
        Log.d(TAG, b.toString())
        Log.d(TAG, c.toString())

        val output: Data = workDataOf("result" to 10)

        return Result.success(output)
    }

    companion object {
        const val TAG: String = "WorkManagerB"
    }

}