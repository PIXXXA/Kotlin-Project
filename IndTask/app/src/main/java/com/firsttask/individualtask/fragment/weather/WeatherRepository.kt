package com.firsttask.individualtask.fragment.weather

import android.content.ContentValues.TAG
import android.util.Log
import com.firsttask.individualtask.BuildConfig.CONSUMER_KEY
import com.firsttask.individualtask.rest.model.ApiResponse
import com.firsttask.individualtask.rest.model.WeatherResponse
import com.firsttask.individualtask.rest.service.WeatherService
import retrofit2.Call
import retrofit2.Response

class WeatherRepository(val weatherService: WeatherService) {

    fun getWeather(coordinate: String, viewModelCallBack: ViewModelCallBack) {
        val getLocationRequest = weatherService.getLocationCode(CONSUMER_KEY, coordinate)
        getLocationRequest?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.d(TAG, t.localizedMessage!!)
                }
            }

            override fun onResponse(
                call: Call<ApiResponse>, locationResponse: Response<ApiResponse>
            ) {
                val getWeatherRequest =
                    weatherService.getWeather(locationResponse.body().toString(), CONSUMER_KEY)
                getWeatherRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                        if (t.localizedMessage != null) {
                            Log.d(TAG, t.localizedMessage!!)
                        }
                    }

                    override fun onResponse(
                        call: Call<WeatherResponse>, weatherResponse: Response<WeatherResponse>
                    ) {
                        val weatherResponse = weatherResponse.body()
                        weatherResponse?.let {
                            viewModelCallBack.onSuccess(
                                weatherResponse, locationResponse.body().toString()
                            )
                        }
                    }
                })
            }
        })
    }

}