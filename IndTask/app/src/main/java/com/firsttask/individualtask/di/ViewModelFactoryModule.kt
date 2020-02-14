package com.firsttask.individualtask.di

import com.firsttask.individualtask.ResourceProvider
import com.firsttask.individualtask.fragment.weather.WeatherFactory
import com.firsttask.individualtask.fragment.weather.WeatherRepository
import com.firsttask.individualtask.fragment.history.HistoryFactory
import com.firsttask.individualtask.fragment.history.HistoryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {
    @Provides
    @Singleton
    fun getHistoryViewModelFactory(
        historyRepository: HistoryRepository, resourceProvider: ResourceProvider
    ): HistoryFactory {
        return HistoryFactory(
            historyRepository, resourceProvider
        )
    }

    @Provides
    @Singleton
    fun getWeatherFactory(weatherRepository: WeatherRepository , resourceProvider: ResourceProvider): WeatherFactory{
        return WeatherFactory(
            weatherRepository,
            resourceProvider
        )
    }
}