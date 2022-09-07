package com.ssd.okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ssd.okhttp.adapter.PostAdapter
import com.ssd.okhttp.model.Post
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var arrayList_Posts: ArrayList<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://jsonplaceholder.typicode.com/todos"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
//                println(response.body?.string())
                val postResponse = response.body!!.string()
                val jsonObject = JSONObject(postResponse)
                val jsonArray: JSONArray = jsonObject.getJSONArray("")
                val size: Int = jsonArray.length()

                arrayList_Posts = ArrayList()

                for (i in 0 until size) {
                    val jsonObjectDetail: JSONObject = jsonArray.getJSONObject(i)
                    val post = Post(
                        jsonObjectDetail.getString("userId"),
                        jsonObjectDetail.getString("id"),
                        jsonObjectDetail.getString("title"),
                    )
                    arrayList_Posts.add(post)
                }

                // update main ui
                runOnUiThread {
                    val objectAdapter = PostAdapter(applicationContext, arrayList_Posts)
                    listView.adapter = objectAdapter
                }
            }
        })
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}