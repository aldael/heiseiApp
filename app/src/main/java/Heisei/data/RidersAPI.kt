package Heisei.data

import Heisei.model.Rider
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RidersAPI {
    @GET("/search")
    fun getRiders(
        @Query("rider") rider: String,
        @Query("identidad") identidad: String
        ) : Call<ArrayList<Rider>>
}