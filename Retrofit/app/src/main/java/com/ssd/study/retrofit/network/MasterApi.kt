package com.ssd.study.retrofit.network

import com.ssd.study.retrofit.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface MasterApi {

    @GET("posts/1")
    suspend fun getUser1(): User

    @GET("posts/{number}")
    suspend fun getUserNumber(
        @Path("number") number: Int
    ): User

}