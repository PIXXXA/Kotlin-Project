package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.repository.WeatherRepository

class WeatherFactory(private val weatherRepository: WeatherRepository, private val resourceProvider: ResourceProvider, private val appDatabase: AppDatabase)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WeatherRepository::class.java, ResourceProvider::class.java, AppDatabase::class.java)
                .newInstance(weatherRepository, resourceProvider, appDatabase)
    }
}