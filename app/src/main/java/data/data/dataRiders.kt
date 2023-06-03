package data.data

import android.content.Context
import com.example.protorider0.Rider
import kotlinx.coroutines.delay
import local.AppDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class dataRiders {
    private val _BASE_URL = "https://run.mocky.io/v3/b1756437-5d5d-4f84-803b-c3af80770098"


    suspend fun getRiders(rider: String, identidad: String, context: Context) : ArrayList<Rider> {
        var rLocal = AppDatabase.getInstance(context).ridersDao().getAll()
        if (rLocal.size > 0) {
            return rLocal.toExternal() as ArrayList<Rider>
        }


        val api = Retrofit.Builder()
           .baseUrl(_BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build().create(RidersAPI::class.java)

       delay(3000)
       var result = api.getRiders(rider, identidad).execute()

       return if (result.isSuccessful) {
           var rList = result.body() ?: ArrayList<Rider>()
           if (rList.size > 0) {
               var rListLocal = rList.toLocal().toTypedArray()
               AppDatabase.getInstance(context).ridersDao().insert(rListLocal)
           }

           rList
       } else {
           ArrayList<Rider>()
       }
    }
}