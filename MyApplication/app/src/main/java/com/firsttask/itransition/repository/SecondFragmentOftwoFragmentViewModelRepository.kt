package com.firsttask.itransition.repository

import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondFragmentOftwoFragmentViewModelRepository(private val appDatabase: AppDatabase) {

    fun getRecyclerViewData(exampleItems: ArrayList<RecyclerViewEntityForSecondActivity>) {

        GlobalScope.launch {
            exampleItems.addAll(appDatabase.weatherDao().getAllWeather().map {
                RecyclerViewEntityForSecondActivity(it.currentDate, it.weatherLocation, it.weatherKey, it.weatherTemperature)
            })
        }
    }
}