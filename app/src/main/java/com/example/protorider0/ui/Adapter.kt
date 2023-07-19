package com.example.protorider0.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.protorider0.R
import com.example.protorider0.model.Rider
import com.example.protorider0.ui.extras.OnItemClickListener


class Adapter(private val listener: OnItemClickListener): RecyclerView.Adapter<ViewHolder>(){

    var riders : MutableList<Rider> = ArrayList<Rider>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.rider_card, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = riders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rider = riders[position]
        holder.rider.text = rider.rider

        Glide.with(holder.itemView.context)
            .load(rider.armor)
            .placeholder(R.drawable.rider_pose)
            .into(holder.armor)

        Glide.with(holder.itemView.context)
            .load(rider.serie)
            .placeholder(R.drawable._0th_kr_mylogo)
            .into(holder.serie)

        holder.itemView.setOnClickListener{
            listener.onItemClick(rider)
        }
    }

    fun Update(lista : MutableList<Rider>){
        riders = lista
        this.notifyDataSetChanged()
    }

}