package com.example.protorider0

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.protorider0.databinding.RiderCardBinding


class Adapter(val rider: List<Rider>): RecyclerView.Adapter<Adapter.Holder>(){

    class Holder(val view: View): RecyclerView.ViewHolder(view){

        val binding = RiderCardBinding.bind(view)

        fun render(rider: Rider){
            binding.tvrider.text = rider.rider
            binding.tvidentidad.text = rider.identidad
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.rider_card, parent, false))
    }

    override fun getItemCount(): Int = rider.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(rider[position])
    }
}