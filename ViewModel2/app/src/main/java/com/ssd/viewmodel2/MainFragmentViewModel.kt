package com.ssd.viewmodel2

import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {

    var countNumber = 0

    fun plus() {
        countNumber++
    }

    fun minus() {
        countNumber--
    }

    fun getCount(): Int {
        return countNumber
    }

}