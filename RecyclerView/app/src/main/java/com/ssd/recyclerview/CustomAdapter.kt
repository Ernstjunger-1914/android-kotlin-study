package com.ssd.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val context: Context,
    private val userDataList: ArrayList<UserData>
) : RecyclerView.Adapter<CustomAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName = itemView.findViewById<TextView>(R.id.userProfileName)
        private val userPhoto = itemView.findViewById<ImageView>(R.id.userProfileImage)
        private val userDescription = itemView.findViewById<TextView>(R.id.userProfileDescription)
        private val userAddress = itemView.findViewById<TextView>(R.id.userProfileAddress)

        fun bind(userData: UserData, context: Context) {
            if (userData.userPhoto != "") {
                val resourceId = context.resources.getIdentifier(
                    userData.userPhoto,
                    "drawable",
                    context.packageName
                )

                if (resourceId > 0) {
                    userPhoto.setImageResource(resourceId)
                } else {
                    userPhoto.setImageResource(R.mipmap.ic_launcher)
                }
            } else {
                userPhoto.setImageResource(R.mipmap.ic_launcher)
            }

            userName.text = userData.userName
            userDescription.text = userData.userDescription
            userAddress.text = userData.userAddress
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(userDataList[position], context)
    }

    override fun getItemCount(): Int {
        return userDataList.size
    }

}