package com.firsttask.itransition

import android.app.Application
import com.firsttask.itransition.dagger.AppModule
import com.firsttask.itransition.dagger.component.AppComponent
import com.firsttask.itransition.dagger.component.DaggerAppComponent

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = buildComponent()
    }

    fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}