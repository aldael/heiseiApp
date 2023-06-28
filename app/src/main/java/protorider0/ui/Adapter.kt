package protorider0.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.protorider0.R
import com.example.protorider0.databinding.RiderCardBinding
import protorider0.model.Rider


class Adapter: RecyclerView.Adapter<ViewHolder>(){

    var riders : MutableList<Rider> = ArrayList<Rider>()
    /* class Holder(val view: View): RecyclerView.ViewHolder(view){

        val binding = RiderCardBinding.bind(view)

        fun render(rider: Rider){
            binding.tvrider.text = rider.rider
            binding.tvidentidad.text = rider.identidad
        }
    } */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.rider_card, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = riders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rider.text = riders[position].rider
        holder.identidad.text = riders[position].identidad
        /*
        Glide.with(holder.itemView.context)
            .load(riders[position].imgUrl)
            .placeholder(R.drawable.Rider_show)
            .into(holder.img)
        */
    }

    fun Update(lista : MutableList<Rider>){
        riders = lista
        this.notifyDataSetChanged()
    }
}