package com.firsttask.itransition

import android.app.Application
import com.firsttask.itransition.dagger.AppModule
import com.firsttask.itransition.dagger.RoomModule
import com.firsttask.itransition.dagger.сomponent.AppComponent
import com.firsttask.itransition.dagger.сomponent.DaggerAppComponent

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = secondBuildComponent()
     }

    fun secondBuildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}