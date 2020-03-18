package com.firsttask.itransition.dagger

import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.repository.CityRepository
import com.firsttask.itransition.repository.HistoryRepository
import com.firsttask.itransition.repository.WeatherRepository
import com.firsttask.itransition.viewModel.viewModelFactory.CityFactory
import com.firsttask.itransition.viewModel.viewModelFactory.HistoryFactory
import com.firsttask.itransition.viewModel.viewModelFactory.WeatherFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VMFactoryModule{
    @Provides
    @Singleton
    fun getSecondVMFactory(weatherRepository: WeatherRepository, resourceProvider: ResourceProvider, appDatabase: AppDatabase): WeatherFactory{
        return WeatherFactory(weatherRepository , resourceProvider , appDatabase)
    }
    @Provides
    @Singleton
    fun getFirstVMFactory(cityRepository: CityRepository): CityFactory {
        return CityFactory(cityRepository)
    }
    @Provides
    @Singleton
    fun getSecondVMFactoryOfTwoFactory(historyRepository: HistoryRepository ): HistoryFactory {
        return HistoryFactory(historyRepository)
    }
}