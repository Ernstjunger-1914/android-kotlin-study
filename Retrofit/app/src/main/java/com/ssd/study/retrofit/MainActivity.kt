package com.ssd.study.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ssd.study.retrofit.network.MasterApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.getInstance().create(MasterApi::class.java)

        api.getPost1().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("$TAG API", response.toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("$TAG API", "fail")
            }
        })

        api.getPostNumber(3).enqueue(object: Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("$TAG API", response.body().toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("$TAG API", "fail")
            }
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}