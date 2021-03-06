package com.firsttask.itransition.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.firsttask.itransition.db.entity.WeatherEntity


@Dao
interface WeatherDao{

    @Insert
    fun insert(weatherEntity: WeatherEntity)

    @Query("Select * from WeatherTable")
    fun getAllWeather():List<WeatherEntity>

    @Query("SELECT COUNT(*) FROM WeatherTable")
    fun getCount(): Int
}