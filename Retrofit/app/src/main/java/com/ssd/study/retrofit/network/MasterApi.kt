package com.ssd.study.retrofit.network

import com.ssd.study.retrofit.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MasterApi {

    @GET("posts/1")
    fun getPost1(): Call<User>

    @GET("posts/{number}")
    fun getPostNumber(
        @Path("number") number: Int
    ): Call<User>

}