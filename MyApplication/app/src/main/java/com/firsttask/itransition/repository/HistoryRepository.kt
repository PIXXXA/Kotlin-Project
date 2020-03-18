package com.firsttask.itransition.repository

import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.entity.Weather
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryRepository(private val appDatabase: AppDatabase) {

    fun getRecyclerViewData(historyCallBack: HistoryCallBack) {

        GlobalScope.launch {
            val exampleItems: ArrayList<Weather> = arrayListOf()

            exampleItems.addAll(appDatabase.weatherDao().getAllWeather().map {
                Weather("Date: " + it.currentDate, "Coordinate: " + it.weatherLocation, "Code: " + it.weatherKey, it.weatherTemperature)
            })
            historyCallBack.setRecyclerViewData(exampleItems)
        }
    }
}