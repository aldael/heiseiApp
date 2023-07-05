package com.example.protorider0.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riders")
data class RiderLocal (
    @PrimaryKey val rider: String,
    val identidad: String,
    val armor: String,
    val fav: Boolean,
    val serie: String
    )