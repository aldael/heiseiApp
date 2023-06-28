package protorider0.data

import android.content.Context
import protorider0.model.Rider

class RidersRepository {
    private val ridersDS = dataRiders()

    suspend fun getRiders(context: Context) : ArrayList<Rider> {
        return ridersDS.getRiders(context)
    }
}