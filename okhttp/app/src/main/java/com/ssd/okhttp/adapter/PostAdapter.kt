package com.ssd.okhttp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ssd.okhttp.R
import com.ssd.okhttp.model.Post
import kotlinx.android.synthetic.main.post_list.view.*

class PostAdapter(
    context: Context,
    posts: ArrayList<Post>
) : BaseAdapter() {

    private val mContext: Context = context
    private val posts: ArrayList<Post>

    init {
        this.posts = posts
    }

    override fun getCount(): Int {
        return posts.size
    }

    override fun getItem(position: Int): Any {
        return posts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.post_list, viewGroup, false)

        rowMain.user_id_textView.text = posts[position].id
        rowMain.id_TextView.text = posts[position].userId
        rowMain.title_textView.text = posts[position].title

        return rowMain
    }

}