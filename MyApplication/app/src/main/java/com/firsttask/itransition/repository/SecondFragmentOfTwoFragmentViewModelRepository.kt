package com.firsttask.itransition.repository

import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondFragmentOfTwoFragmentViewModelRepository(private val appDatabase: AppDatabase) {

    fun getRecyclerViewData(exampleItem: ArrayList<RecyclerViewEntityForSecondActivity> , historyCallBack: HistoryCallBack) {

        GlobalScope.launch {
            exampleItem.addAll(appDatabase.weatherDao().getAllWeather().map {
                RecyclerViewEntityForSecondActivity(it.currentDate, it.weatherLocation, it.weatherKey, it.weatherTemperature)
            })
            historyCallBack.setRecyclerView(exampleItem = exampleItem)
        }
    }
}