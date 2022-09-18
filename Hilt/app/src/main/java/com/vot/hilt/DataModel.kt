package com.vot.hilt

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataModel @Inject constructor() {
    var message: String = ""
}