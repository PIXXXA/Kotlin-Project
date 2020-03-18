package com.firsttask.itransition.dagger

import android.content.Context
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.repository.CityRepository
import com.firsttask.itransition.repository.HistoryRepository
import com.firsttask.itransition.repository.WeatherRepository
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
    fun getSecondViewModelRepository(weatherService: WeatherService):WeatherRepository{
        return WeatherRepository(weatherService)
    }
    @Provides
    @Singleton
    fun getFirstViewModelRepository(): CityRepository {
        return CityRepository()
    }
    @Provides
    @Singleton
    fun getSecondFragmentOfTwoFragmentViewModelRepository(appDatabase: AppDatabase) :HistoryRepository{
        return HistoryRepository(appDatabase)
    }
}