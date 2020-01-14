package com.firsttask.itransition.repository

import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondFragmentOfTwoFragmentViewModelRepository(private val appDatabase: AppDatabase) {

    fun getRecyclerViewData(historyCallBack: HistoryCallBack) {

        GlobalScope.launch {
            val exampleItems: ArrayList<RecyclerViewEntityForSecondActivity> = arrayListOf()

            exampleItems.addAll(appDatabase.weatherDao().getAllWeather().map {
                RecyclerViewEntityForSecondActivity(it.currentDate, it.weatherLocation, it.weatherKey, it.weatherTemperature)
            })
            historyCallBack.setRecyclerViewData(exampleItems)
        }
    }
}