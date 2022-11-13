package com.ssd.study.retrofit2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ssd.study.retrofit2.R
import com.ssd.study.retrofit2.model.Plant

class MainViewHolder(
    val context: Context,
    val dataSet: List<Plant>
) : RecyclerView.Adapter<MainViewHolder.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plants, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
        Glide.with(context)
            .load(dataSet[position].imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = dataSet.size

}