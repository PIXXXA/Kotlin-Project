package com.firsttask.itransition.dagger

import android.content.Context
import androidx.annotation.Nullable
import androidx.room.Room
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.NAME_OF_DB
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(context: Context){

    private val appDatabase: AppDatabase = Room.databaseBuilder(context.applicationContext , AppDatabase::class.java , NAME_OF_DB).build()

    @Provides
    @Singleton
    fun getAppDatabase():AppDatabase{
        return appDatabase
    }

    @Provides
    @Singleton
    fun getDao(appDatabase: AppDatabase):WeatherDao{
        return appDatabase.weatherDao()
    }
}