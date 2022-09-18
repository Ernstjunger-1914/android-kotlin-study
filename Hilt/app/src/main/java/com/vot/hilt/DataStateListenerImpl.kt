package com.vot.hilt

import android.app.Activity
import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataStateListenerImpl @Inject constructor(
    private val activity: Activity,
    @ApplicationContext private val context: Context
) : OnDataStateListener {
    companion object {
        const val TAG: String = "DataStateListenerImpl"
    }

    override fun state(message: String) {
        Log.d(TAG, message)
    }
}