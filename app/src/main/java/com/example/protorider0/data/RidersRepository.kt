package com.example.protorider0.data

import android.content.Context
import com.example.protorider0.model.Rider

class RidersRepository {
    private val ridersDS = DataRiders()

    suspend fun getRiders(rider: String, context: Context) : ArrayList<Rider> {
        return ridersDS.getRiders(rider, context)
    }
}