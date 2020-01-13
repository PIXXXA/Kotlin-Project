package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import com.firsttask.itransition.repository.HistoryCallBack
import com.firsttask.itransition.repository.SecondFragmentOfTwoFragmentViewModelRepository

class SecondFragmentOfTwoFragmentViewModel(private val secondFragmentOfTwoFragmentViewModelRepository: SecondFragmentOfTwoFragmentViewModelRepository) : ViewModel() {
    val exampleItems = ArrayList<RecyclerViewEntityForSecondActivity>()

    fun getRecyclerView() {
        secondFragmentOfTwoFragmentViewModelRepository.getRecyclerViewData(exampleItems, object : HistoryCallBack {
            override fun setRecyclerView(exampleItem: ArrayList<RecyclerViewEntityForSecondActivity>) {}
        })
    }
}