package com.firsttask.individualtask

import android.app.Application
import com.firsttask.individualtask.di.AppModule
import com.firsttask.individualtask.di.component.AppComponent
import com.firsttask.individualtask.di.component.DaggerAppComponent

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = buildComponent()
    }

    private fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}