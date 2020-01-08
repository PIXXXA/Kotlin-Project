package com.firsttask.itransition.dagger

import android.content.Context
import com.firsttask.itransition.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule{
    @Provides
    @Singleton
    fun getAppDatabase(context: Context): AppDatabase?{
        return  AppDatabase.getDatabase(context)
    }
}