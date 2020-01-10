package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import com.firsttask.itransition.repository.SecondFragmentOftwoFragmentViewModelRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondFragmentOfTwoFragmentViewModel(private val secondFragmentOftwoFragmentViewModelRepository: SecondFragmentOftwoFragmentViewModelRepository) : ViewModel() {
    val exampleItems = ArrayList<RecyclerViewEntityForSecondActivity>()

    fun getRecyclerview(){
        secondFragmentOftwoFragmentViewModelRepository.getRecyclerViewData(exampleItems)
    }
}