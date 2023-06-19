package Heisei.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protorider0.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rider: TextView = itemView.findViewById(R.id.tvrider)
    val identidad: TextView = itemView.findViewById(R.id.tvidentidad)
}