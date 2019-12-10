package com.firsttask.itransition.retrofit

import com.firsttask.itransition.adapter.DailyForecasts
import com.firsttask.itransition.adapter.WeatherLocationGSONAdapter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AccuweatherClient {
    @GET("/locations/v1/cities/geoposition/search")
    fun getLocationCode(@Query("apikey") apiKey: String?, @Query("q") q: String?): Call<WeatherLocationGSONAdapter>?

    @GET("/forecasts/v1/daily/1day/{location}")
    fun getWeather(@Path("location") location: String, @Query("apikey") apiKey1: String): Call<DailyForecasts>
}