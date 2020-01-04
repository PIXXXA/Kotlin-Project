package com.firsttask.itransition.dagger

import android.content.Context
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.FirstViewModelRepository
import com.firsttask.itransition.repository.SecondViewModelRepository
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
    fun getSecondViewModelRepository(weatherService: WeatherService):SecondViewModelRepository{
        return SecondViewModelRepository(weatherService)
    }
    @Provides
    @Singleton
    fun getFirstViewModelRepository(): FirstViewModelRepository {
        return FirstViewModelRepository()
    }
}