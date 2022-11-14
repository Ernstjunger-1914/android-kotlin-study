package com.ssd.study.room.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ssd.study.room.db.TextDataBase
import com.ssd.study.room.entity.Text
import com.ssd.study.room.entity.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = TextDataBase.getDataBase(context)

    private var _getText = MutableLiveData<List<Text>>()
    val getText: LiveData<List<Text>>
        get() = _getText

    private var _getWord = MutableLiveData<List<Word>>()
    val getWord: LiveData<List<Word>>
        get() = _getWord

    fun select() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(MainActivity.TAG, db.textDao().getAllData().toString())
        Log.d(MainActivity.TAG, db.wordDao().getAllData().toString())
        _getText.postValue(db.textDao().getAllData())
        _getWord.postValue(db.wordDao().getAllData())
    }

    fun insert(text: String) = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().insert(Text(0, text))
        db.wordDao().insert(Word(0, text))
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
    }

    companion object {
        const val TAG: String = "MainViewModel"
    }

}