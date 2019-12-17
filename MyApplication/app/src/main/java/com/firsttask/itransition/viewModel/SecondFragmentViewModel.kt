package com.firsttask.itransition.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.KEY
import com.firsttask.itransition.R
import com.firsttask.itransition.TAG
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response

class SecondFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var a1 :String? = null
    var a2 :String? = null

    private val bodyKey = MutableLiveData<String>()
    private val weather = MutableLiveData<String>()

    fun getWeather() {

        val locationKeyRequest = getApplication<BaseApplication>().restClient.getDailyForecast()?.getLocationCode(KEY, a2)
        locationKeyRequest?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.d(TAG, t.localizedMessage!!)
                }
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                bodyKey.value = response.body()?.key
                val weatherKeyRequest = getApplication<BaseApplication>().restClient.getDailyForecast()?.getWeather(response.body()?.key, KEY)

                weatherKeyRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                        val weatherResponse = response.body()
                        weatherResponse?.let { getWeather ->
                            val stringBuilder =
                                    "${(R.string.date)}${getWeather.dailyForecasts?.first()?.nowDate}" +
                                            "\n${getApplication<BaseApplication>().getString(R.string.temp_max)}${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
                                            "\n${getApplication<BaseApplication>().getString(R.string.temp_min)}${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
                            weather.value = stringBuilder
                        }
                    }
                })
            }
        })
    }

    fun getbodyKey(): LiveData<String> {
        return bodyKey
    }

    fun getweather(): LiveData<String> {
        return weather
    }
}