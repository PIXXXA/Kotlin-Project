package com.firsttask.itransition.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.KEY
import com.firsttask.itransition.R
import com.firsttask.itransition.TAG
import com.firsttask.itransition.rest.RestClient
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response

class SecondFragmentViewModel(val restClient: RestClient, val coordAdapter: String) : ViewModel() {

    private val bodyKey = MutableLiveData<String>()
    private val weather = MutableLiveData<String>()

    init {

        val getWeatherResponse = restClient.getDailyForecast()?.getLocationCode(KEY, coordAdapter)
        getWeatherResponse?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.d(TAG, t.localizedMessage!!)
                }
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                bodyKey.value = response.body()?.key
                val weatherKeyRequest = restClient.getDailyForecast()?.getWeather(bodyKey.value, KEY)

                weatherKeyRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    }

//                    ${getApplication<BaseApplication>().getString(R.string.temp_max)}
//                    ${getApplication<BaseApplication>().getString(R.string.temp_min)}

                    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                        val weatherResponse = response.body()
                        weatherResponse?.let { getWeather ->
                            val stringBuilder =
                                    "${(R.string.date)}${getWeather.dailyForecasts?.first()?.nowDate}" +
                                            "\n${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
                                            "\n${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
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