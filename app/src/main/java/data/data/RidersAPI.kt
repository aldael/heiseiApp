package data.data

import retrofit2.Call
import com.example.protorider0.Rider
import retrofit2.http.GET
import retrofit2.http.Query

interface RidersAPI {
    @GET("/search")
    fun getRiders(
        @Query("rider") name: String,
        @Query("identidad") identidad: String
        ) : Call<ArrayList<Rider>>
}