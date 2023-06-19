package Heisei.data

import android.content.Context
import Heisei.model.Rider

class RidersRepository {
    private val ridersDS = dataRiders()

    suspend fun getRiders(rider: String, identidad: String, context: Context) : ArrayList<Rider> {
        return ridersDS.getRiders(rider, identidad, context)
    }
}