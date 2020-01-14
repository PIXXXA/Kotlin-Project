package com.firsttask.itransition.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import com.firsttask.itransition.repository.HistoryCallBack
import com.firsttask.itransition.repository.SecondFragmentOfTwoFragmentViewModelRepository

class SecondFragmentOfTwoFragmentViewModel(private val secondFragmentOfTwoFragmentViewModelRepository: SecondFragmentOfTwoFragmentViewModelRepository) : ViewModel() {
    val exampleItems =  MutableLiveData<ArrayList<RecyclerViewEntityForSecondActivity>>()

    fun getRecyclerViewData() {
        secondFragmentOfTwoFragmentViewModelRepository.getRecyclerViewData(object : HistoryCallBack {
            override fun setRecyclerViewData(exampleItem: ArrayList<RecyclerViewEntityForSecondActivity>) {
                exampleItems.postValue(exampleItem)
            }
        })
    }
}