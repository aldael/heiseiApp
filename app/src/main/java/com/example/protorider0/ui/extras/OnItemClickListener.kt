package com.example.protorider0.ui.extras

import androidx.appcompat.view.menu.MenuView.ItemView
import com.example.protorider0.model.Rider

interface OnItemClickListener {
    fun onItemClick(rider: Rider)
}