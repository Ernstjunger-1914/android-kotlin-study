package com.ssd.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var countNumber = 0

    init {
        Log.d(TAG, "init.")
    }

    fun plus() {
        countNumber++

        Log.d(TAG, countNumber.toString())
    }

    fun minus() {
        countNumber--

        Log.d(TAG, countNumber.toString())
    }

    fun getCount(): Int {
        return countNumber
    }

    companion object {
        const val TAG: String = "MainViewModel"
    }

}