package com.firsttask.individualtask.di

import android.content.Context
import com.firsttask.individualtask.ResourceProvider
import com.firsttask.individualtask.fragment.weather.WeatherRepository
import com.firsttask.individualtask.fragment.history.HistoryRepository
import com.firsttask.individualtask.rest.service.WeatherService
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
    fun getHistoryRepository(): HistoryRepository {
        return HistoryRepository()
    }

    @Provides
    @Singleton
    fun getWeatherRepository(weatherService: WeatherService): WeatherRepository{
        return WeatherRepository(weatherService)
    }
}