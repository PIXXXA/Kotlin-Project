package com.firsttask.itransition.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.firsttask.itransition.NAME_OF_DB
import com.firsttask.itransition.db.dao.WeatherDao
import com.firsttask.itransition.db.entity.WeatherEntity

@Database(
        entities = arrayOf(WeatherEntity::class),
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

//    companion object {
//        private var instance: AppDatabase? = null
//        fun getDatabase(context: Context):AppDatabase{
//            if(instance ==null){
//                synchronized(AppDatabase::class){
//                    instance = Room.databaseBuilder(
//                            context.applicationContext,
//                            AppDatabase::class.java, NAME_OF_DB
//                    ).build()
//                }
//            }
//            return instance!!
//        }
//    }
}