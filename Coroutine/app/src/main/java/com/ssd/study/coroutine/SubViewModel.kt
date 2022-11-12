package com.ssd.study.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SubViewModel : ViewModel() {

    /**
     * SubActivity를 종료해도 계속 동작
     */
    fun one() {
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0..10) {
                delay(500)
                Log.d(TAG, i.toString())
            }
        }
    }

    /**
     * SubActivity를 종료하면 동작하지 않음.
     */
    fun two() {
        viewModelScope.launch {
            for (i in 11..20) {
                delay(500)
                Log.d(TAG, i.toString())
            }
        }
    }

    companion object {
        const val TAG: String = "SubViewModel"
    }

}