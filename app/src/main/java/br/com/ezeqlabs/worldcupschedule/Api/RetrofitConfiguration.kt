package br.com.ezeqlabs.worldcupschedule.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration {
    companion object {
        fun getService() : WorldCupInterface{
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://firebasestorage.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(WorldCupInterface::class.java)
        }
    }
}