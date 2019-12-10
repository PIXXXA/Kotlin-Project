package com.firsttask.itransition.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AccuweatherRetrofit {
    private var accuweatherClient: AccuweatherClient? = null

    init {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://dataservice.accuweather.com")
                .build()
        accuweatherClient = retrofit.create(AccuweatherClient::class.java)
    }

    fun getDailyForecast(): AccuweatherClient? {
        return accuweatherClient
    }
}