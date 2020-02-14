package com.firsttask.individualtask.rest.service

import com.firsttask.individualtask.rest.model.ApiResponse
import com.firsttask.individualtask.rest.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("/locations/v1/cities/geoposition/search")
    fun getLocationCode(@Query("apikey") apiKey: String?, @Query("q") currentCoordinate: String?): Call<ApiResponse>?

    @GET("/forecasts/v1/daily/1day/{location}")
    fun getWeather(@Path("location") locationCode: String?, @Query("apikey") apiKey: String?): Call<WeatherResponse>?
}