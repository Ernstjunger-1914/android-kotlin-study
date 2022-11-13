package com.ssd.study.retrofit2.repository

import com.ssd.study.retrofit2.network.ApiHelper
import com.ssd.study.retrofit2.network.MasterApi

class Repository {

    private val client = ApiHelper.getInstance().create(MasterApi::class.java)

    suspend fun getAllPlants() = client.getAllPlants()

}