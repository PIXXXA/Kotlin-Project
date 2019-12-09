package com.firsttask.itransition

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KotlinRequestWeather {
        @GET("forecasts/v1/daily/1day/{location}")
        fun getWeather(@Query("location") location: String, @Query("apikey") apiKey1: String): Call<DailyForecasts>
    }