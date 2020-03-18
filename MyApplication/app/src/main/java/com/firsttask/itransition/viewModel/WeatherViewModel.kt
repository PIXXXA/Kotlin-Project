package com.firsttask.itransition.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.IMAGE_URL
import com.firsttask.itransition.R
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.db.entity.WeatherEntity
import com.firsttask.itransition.repository.WeatherRepository
import com.firsttask.itransition.repository.ViewModelCallBack
import com.firsttask.itransition.rest.model.WeatherResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherRepository: WeatherRepository, private val resourceProvider: ResourceProvider, private val appDatabase: AppDatabase) : ViewModel() {

    var bodyKey = MutableLiveData<String?>()
    var weather = MutableLiveData<String?>()
    var dateAdapter = MutableLiveData<String?>()
    var coordinateAdapter = MutableLiveData<String?>()
    val imageUrl = IMAGE_URL

    fun getRequest(coordAdapter: String? = null) {
        coordinateAdapter.value = coordAdapter

        weatherRepository.getRetrofitRequest(coordAdapter,
                object : ViewModelCallBack {
                    override fun onSuccess(stringBuilder: WeatherResponse, locationKey: String?) {
                        stringBuilder.let { getWeather ->
                            val weatherData =
                                    "${resourceProvider.getString(R.string.temp_max)}${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
                                            "\n${resourceProvider.getString(R.string.temp_min)}${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
                            weather.value = weatherData
                        }
                        bodyKey.value = locationKey

                        GlobalScope.launch {
                            appDatabase.weatherDao().insert(WeatherEntity(null ,bodyKey.value, dateAdapter.value, coordinateAdapter.value, weather.value))
                        }
                    }
                })
    }
}