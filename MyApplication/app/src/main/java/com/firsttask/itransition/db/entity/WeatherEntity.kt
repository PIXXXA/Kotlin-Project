package com.firsttask.itransition.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WeatherTable")
data class WeatherEntity(
        @PrimaryKey(autoGenerate = true)
        var weatherPK:Int?,
        var weatherKey: String? = null,
        var currentDate: String? = null,
        var weatherLocation: String? = null,
        var weatherTemperature: String? = null
)