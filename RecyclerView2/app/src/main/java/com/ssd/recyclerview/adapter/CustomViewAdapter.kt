package com.ssd.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ssd.recyclerview.R
import com.ssd.recyclerview.databinding.CellListTextBinding

class CustomViewAdapter(
    private val dataSet: ArrayList<String>
) : RecyclerView.Adapter<CustomViewAdapter.ViewHolder>() {

    class ViewHolder(binding: CellListTextBinding) : RecyclerView.ViewHolder(binding.root) {
        val text: TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CellListTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}