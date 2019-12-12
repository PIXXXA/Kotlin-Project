package com.firsttask.itransition.rest

import com.firsttask.itransition.rest.service.WeatherService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {
    private var weatherService: WeatherService? = null

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://dataservice.accuweather.com")
                .client(client)
                .build()
        weatherService = retrofit.create(WeatherService::class.java)
    }

    fun getDailyForecast(): WeatherService? {
        return weatherService
    }
}