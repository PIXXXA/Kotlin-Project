package com.firsttask.itransition.dagger.сomponent

import com.firsttask.itransition.dagger.*
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.db.dao.WeatherDao
import com.firsttask.itransition.fragment.RecyclerViewFragment
import com.firsttask.itransition.fragment.SecondFragmentOfTwoFragmentForSecondActivity
import com.firsttask.itransition.fragment.SecondScreenFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UtilsModule::class , VMFactoryModule::class , NetworkModule::class , RoomModule::class])
interface AppComponent {
    fun inject(secondScreenFragment: SecondScreenFragment)
    fun inject(recyclerViewFragment: RecyclerViewFragment)
    fun inject(secondFragmentOfTwoFragmentForSecondActivity: SecondFragmentOfTwoFragmentForSecondActivity)

    var weatherDao: WeatherDao
    var appDatabase:AppDatabase
}