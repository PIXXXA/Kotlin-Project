package com.firsttask.itransition.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.Weather
import com.firsttask.itransition.repository.HistoryCallBack
import com.firsttask.itransition.repository.HistoryRepository

class HistoryViewModel(private val historyRepository: HistoryRepository) : ViewModel() {
    val exampleItems =  MutableLiveData<ArrayList<Weather>>()

    fun getRecyclerViewData() {
        historyRepository.getRecyclerViewData(object : HistoryCallBack {
            override fun setRecyclerViewData(exampleItem: ArrayList<Weather>) {
                exampleItems.postValue(exampleItem)
            }
        })
    }
}