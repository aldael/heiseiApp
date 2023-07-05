package com.example.protorider0.data

import android.content.Context
import com.example.protorider0.model.Rider
import kotlinx.coroutines.delay
import com.example.protorider0.data.local.AppDatabase
import com.example.protorider0.data.local.toLocal
import com.example.protorider0.data.local.toExternal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRiders {
    private val _BASE_URL = "https://run.mocky.io/v3/c54dea56-aa61-4e64-9211-722ca49aed25"


    suspend fun getRiders(rider: String, context: Context) : ArrayList<Rider> {
        var rLocal = AppDatabase.getInstance(context).ridersDao().getAll()
        if (rLocal.size > 0) {
            return rLocal.toExternal() as ArrayList<Rider>
        }


        val api = Retrofit.Builder()
           .baseUrl(_BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build().create(RidersAPI::class.java)
       var result = api.getRiders(rider).execute()
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

