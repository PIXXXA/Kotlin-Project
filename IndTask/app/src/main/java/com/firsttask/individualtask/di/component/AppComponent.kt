package com.firsttask.individualtask.di.component

import com.firsttask.individualtask.di.AppModule
import com.firsttask.individualtask.di.NetworkModule
import com.firsttask.individualtask.di.UtilsModule
import com.firsttask.individualtask.di.ViewModelFactoryModule
import com.firsttask.individualtask.fragment.history.HistoryFragment
import com.firsttask.individualtask.fragment.map.MapFragment
import com.firsttask.individualtask.fragment.weather.WeatherFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UtilsModule::class, NetworkModule::class,
    ViewModelFactoryModule::class])
interface AppComponent {
    fun inject(historyFragment: HistoryFragment)
    fun inject(weatherFragment: WeatherFragment)

}

