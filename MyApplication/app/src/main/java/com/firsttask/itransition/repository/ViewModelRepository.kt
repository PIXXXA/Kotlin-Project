package com.firsttask.itransition.repository

import android.util.Log
import com.firsttask.itransition.CONSUMERKEY
import com.firsttask.itransition.TAG
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import com.firsttask.itransition.rest.service.WeatherService
import retrofit2.Call
import retrofit2.Response

class ViewModelRepository(val weatherService: WeatherService) {

    fun getRetrofitRequest(coordAdapter: String? = null, viewModelCallBack: ViewModelCallBack) {


        val getWeatherResponse = weatherService.getLocationCode(CONSUMERKEY, coordAdapter)
        getWeatherResponse?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.d(TAG, t.localizedMessage!!)
                }
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                val weatherKeyRequest = weatherService.getWeather(response.body()?.key, CONSUMERKEY)
                val locationKey = response.body()?.key

                weatherKeyRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                        Log.d(TAG, t.localizedMessage!!)
                    }

                    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                        val weatherResponse = response.body()
                        weatherResponse?.let { viewModelCallBack.onSucess(weatherResponse, locationKey) }
                    }
                })
            }
        })
    }
}