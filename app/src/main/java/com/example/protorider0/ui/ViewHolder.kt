package com.example.protorider0.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protorider0.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rider: TextView = itemView.findViewById(R.id.tvrider)
    val armor: ImageView = itemView.findViewById(R.id.imageRider)
    val serie: ImageView = itemView.findViewById(R.id.imageSerie)
}