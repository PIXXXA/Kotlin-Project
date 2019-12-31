package com.firsttask.itransition.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.KEY
import com.firsttask.itransition.R
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.TAG
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import com.firsttask.itransition.rest.service.WeatherService
import retrofit2.Call
import retrofit2.Response

class SecondFragmentViewModel(val weatherService: WeatherService, val resourceProvider: ResourceProvider) : ViewModel() {

    var bodyKey = MutableLiveData<String>()
    var weather = MutableLiveData<String>()
    var dateAdapter = MutableLiveData<String?>()
    var coordinateAdapter = MutableLiveData<String?>()
    val imageUrl = "https://i.pinimg.com/originals/84/c5/97/84c597187f11c618c2558f57ac83f8de.jpg"

    fun getRequest(coordAdapter: String? = null) {
        coordinateAdapter.value = coordAdapter
        val getWeatherResponse = weatherService.getLocationCode(KEY, coordinateAdapter.value)
        getWeatherResponse?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.d(TAG, t.localizedMessage!!)
                }
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                bodyKey.value = response.body()?.key
                val weatherKeyRequest = weatherService.getWeather(bodyKey.value, KEY)

                weatherKeyRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                        Log.d(TAG, t.localizedMessage!!)
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