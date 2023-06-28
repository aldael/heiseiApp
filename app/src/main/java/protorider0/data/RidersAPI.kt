package protorider0.data

import protorider0.model.Rider
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RidersAPI {
    @GET("/search")
    fun getRiders(
        rider: String,
        identidad: String,
        armor: String,
        fav: Boolean,
        serie: String
        ) : Call<ArrayList<Rider>>
}