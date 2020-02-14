package com.firsttask.individualtask.fragment.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.individualtask.R
import com.firsttask.individualtask.ResourceProvider
import com.firsttask.individualtask.rest.model.WeatherResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository, private val resourceProvider: ResourceProvider
) : ViewModel() {
    val currentDate = MutableLiveData<String>()
    val temperatureMax = MutableLiveData<String>()
    val temperatureMin = MutableLiveData<String>()
    var location = MutableLiveData<String>()


    fun currentLocation(latitude:String?, longitude:String?){
        location.value="${latitude}+${longitude}"
        currentDate.value="21323"
        temperatureMax.value="21323"
        temperatureMin.value="21323"
    }

//    fun getRequest(coordAdapter: String? = null) {
//
//        weatherRepository.getWeather(coordAdapter,
//            object : ViewModelCallBack {
//                override fun onSuccess(stringBuilder: WeatherResponse, locationKey: String?) {
//                    stringBuilder.let { getWeather ->
//                        val weatherData =
//                            "\n${resourceProvider.getString(R.string.temp_max)}${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
//                                    "\n${resourceProvider.getString(R.string.temp_min)}${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
//                        weather.value = weatherData
//                    }
//                    bodyKey.value = locationKey
//
//                    GlobalScope.launch {
//                        appDatabase.weatherDao().insert(WeatherEntity(null ,bodyKey.value, dateAdapter.value, coordinateAdapter.value, weather.value))
//                    }
//                }
//            })
//    }
}