package com.firsttask.itransition

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRetrofitClass {
    private var dailyForecasts: DailyForecasts? = null

    init {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://dataservice.accuweather.com")
                .build()
        dailyForecasts = retrofit.create(DailyForecasts::class.java)
    }

    fun getDailyForecast(): DailyForecasts? {
        return dailyForecasts
    }
}