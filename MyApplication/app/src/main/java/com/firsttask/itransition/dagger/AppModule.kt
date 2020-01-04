package com.firsttask.itransition.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun secondProvideContext(): Context {
        return context
    }
}