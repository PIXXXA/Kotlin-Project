package com.firsttask.itransition.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.KEY
import com.firsttask.itransition.R
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.TAG
import com.firsttask.itransition.rest.RestClient
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response

class SecondFragmentViewModel(val restClient: RestClient, val coordAdapter: String, val dateAdapter: String, resourceProvider: ResourceProvider) : ViewModel() {

    val bodyKey = MutableLiveData<String>()
    val weather = MutableLiveData<String>()
    val imageUrl = "https://i.pinimg.com/originals/84/c5/97/84c597187f11c618c2558f57ac83f8de.jpg"

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

                    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                        val weatherResponse = response.body()
                        weatherResponse?.let { getWeather ->
                            val stringBuilder =
                                    "${(R.string.date)}${getWeather.dailyForecasts?.first()?.nowDate}" +
                                            "\n${resourceProvider.getString(R.string.temp_max)}${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
                                            "\n${resourceProvider.getString(R.string.temp_min)}${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
                            weather.value = stringBuilder
                        }
                    }
                })
            }
        })
    }
}