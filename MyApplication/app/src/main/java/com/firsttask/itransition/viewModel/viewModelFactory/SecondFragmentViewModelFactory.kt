package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.rest.service.WeatherService

class SecondFragmentViewModelFactory(val weatherService: WeatherService,val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WeatherService::class.java, ResourceProvider::class.java)
                .newInstance(weatherService, resourceProvider)
    }
}