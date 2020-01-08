package com.firsttask.itransition.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.R
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.db.entity.WeatherEntity
import com.firsttask.itransition.repository.SecondViewModelRepository
import com.firsttask.itransition.repository.ViewModelCallBack
import com.firsttask.itransition.rest.model.WeatherResponse
import javax.inject.Inject

class SecondFragmentViewModel(private val secondViewModelRepository: SecondViewModelRepository, private val resourceProvider: ResourceProvider) : ViewModel() {

    @Inject
    lateinit var appDatabase: AppDatabase

    var bodyKey = MutableLiveData<String?>()
    var weather = MutableLiveData<String?>()
    var dateAdapter = MutableLiveData<String?>()
    var coordinateAdapter = MutableLiveData<String?>()
    val imageUrl = "https://i.pinimg.com/originals/84/c5/97/84c597187f11c618c2558f57ac83f8de.jpg"

    fun getRequest(coordAdapter: String? = null) {
        coordinateAdapter.value = coordAdapter

        secondViewModelRepository.getRetrofitRequest(coordAdapter,
                object : ViewModelCallBack {
                    override fun onSuccess(stringBuilder: WeatherResponse, locationKey: String?) {
                        stringBuilder.let { getWeather ->
                            val weatherData =
                                    "\n${resourceProvider.getString(R.string.temp_max)}${getWeather.dailyForecasts?.first()?.temperature?.maximum?.valueMax}" +
                                            "\n${resourceProvider.getString(R.string.temp_min)}${getWeather.dailyForecasts?.first()?.temperature?.minimum?.valueMin}"
                            weather.value = weatherData
                        }
                        bodyKey.value = locationKey

                        suspend fun workA(){
                            appDatabase.weatherDao().insert(WeatherEntity(0, bodyKey.value, dateAdapter.value, coordinateAdapter.value, weather.value))
                        }
                    }
                })
    }
}