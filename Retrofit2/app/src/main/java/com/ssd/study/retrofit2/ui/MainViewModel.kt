package com.ssd.study.retrofit2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssd.study.retrofit2.model.Plant
import com.ssd.study.retrofit2.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //val retrofitInstance = ApiHelper.getInstance().create(MasterApi::class.java)
    private val repository = Repository()


    private val _getAllPlants = MutableLiveData<List<Plant>>()
    val getAllPlants: LiveData<List<Plant>>
        get() = _getAllPlants

    fun getAllPlants() = viewModelScope.launch {
        Log.d(TAG, repository.getAllPlants().toString())
        _getAllPlants.value = repository.getAllPlants()
    }

    companion object {
        const val TAG: String = "MainViewModel"
    }

}