package com.ssd.study.retrofit2.network

import com.ssd.study.retrofit2.model.Plant
import retrofit2.http.GET

interface MasterApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants(): List<Plant>

}