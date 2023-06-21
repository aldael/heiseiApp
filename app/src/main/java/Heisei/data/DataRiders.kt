package Heisei.data

import android.content.Context
import Heisei.model.Rider
import kotlinx.coroutines.delay
import Heisei.data.local.AppDatabase
import Heisei.data.local.toLocal
import Heisei.data.local.toExternal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class dataRiders {
    private val _BASE_URL = "https://run.mocky.io/v3/a908df41-49b5-428b-a73d-8a3a4dac2d2c"


    suspend fun getRiders(context: Context) : ArrayList<Rider> {
        var rLocal = AppDatabase.getInstance(context).ridersDao().getAll()
        if (rLocal.size > 0) {
            return rLocal.toExternal() as ArrayList<Rider>
        }


        val api = Retrofit.Builder()
           .baseUrl(_BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build().create(RidersAPI::class.java)

       delay(3000)
       var result = api.getRiders().execute()
       return if (result.isSuccessful) {
           var rList = result.body() ?: ArrayList<Rider>()
           if (rList.size > 0) {
               var rListLocal = rList.toLocal().toTypedArray()
               AppDatabase.getInstance(context).ridersDao().insert(*rListLocal)
           }

           rList
       } else {
           ArrayList<Rider>()
       }
    }
}

