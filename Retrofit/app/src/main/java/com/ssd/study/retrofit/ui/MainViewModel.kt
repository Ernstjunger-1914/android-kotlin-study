package com.ssd.study.retrofit.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssd.study.retrofit.network.MasterApi
import com.ssd.study.retrofit.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val retrofitInstance = RetrofitInstance.getInstance().create(MasterApi::class.java)

    private var _mutableUser1 = MutableLiveData<String>()
    val getUser1: LiveData<String>
        get() = _mutableUser1

    private var _mutableUser2 = MutableLiveData<String>()
    val getUser2: LiveData<String>
        get() = _mutableUser2

    fun getUser1() = viewModelScope.launch {
        val user = retrofitInstance.getUser1()

        Log.d(TAG, user.toString())
        _mutableUser1.value = user.title
    }

    fun getUserNumber(number: Int) = viewModelScope.launch {
        val user = retrofitInstance.getUserNumber(number)

        Log.d(TAG, user.toString())
        _mutableUser2.value = user.title
    }

    companion object {
        const val TAG: String = "MainViewModel"
    }

}