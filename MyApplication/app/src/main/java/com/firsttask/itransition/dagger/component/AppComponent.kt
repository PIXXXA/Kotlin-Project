package com.firsttask.itransition.dagger.component

import com.firsttask.itransition.dagger.AppModule
import com.firsttask.itransition.dagger.NetworkModule
import com.firsttask.itransition.dagger.UtilsModule
import com.firsttask.itransition.dagger.VMFactoryModule
import com.firsttask.itransition.fragment.SecondScreenFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UtilsModule::class , VMFactoryModule::class , NetworkModule::class])
interface AppComponent {
    fun inject(secondScreenFragment: SecondScreenFragment)
}