package com.ssd.study.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // 기본값은 0
    var mutableLiveData = MutableLiveData(0)

    fun addLiveDataValue() {
        mutableLiveData.value = mutableLiveData.value!!.plus(1)
    }

    companion object {
        const val TAG: String = "MainViewModel"
    }

}