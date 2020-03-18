package com.firsttask.itransition.dagger.сomponent

import com.firsttask.itransition.dagger.*
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.db.dao.WeatherDao
import com.firsttask.itransition.fragment.CityFragment
import com.firsttask.itransition.fragment.HistoryFragment
import com.firsttask.itransition.fragment.WeatherFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UtilsModule::class , VMFactoryModule::class , NetworkModule::class , RoomModule::class])
interface AppComponent {
    fun inject(weatherFragment: WeatherFragment)
    fun inject(cityFragment: CityFragment)
    fun inject(historyFragment: HistoryFragment)

    var weatherDao: WeatherDao
    var appDatabase:AppDatabase
}