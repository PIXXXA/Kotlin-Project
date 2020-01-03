package com.firsttask.itransition.dagger

import android.content.Context
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.ViewModelRepository
import com.firsttask.itransition.rest.service.WeatherService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun getResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context)
    }
    @Provides
    @Singleton
    fun getViewModelRepository(weatherService: WeatherService):ViewModelRepository{
        return ViewModelRepository(weatherService)
    }
}