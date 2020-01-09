package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.RecyclerViewEntity
import com.firsttask.itransition.repository.FirstViewModelRepository
import java.util.*

class FirstFragmentViewModel(private val firstViewModelRepository: FirstViewModelRepository) : ViewModel() {
    val exampleItems = ArrayList<RecyclerViewEntity>()

    fun getRecyclerView() {
        firstViewModelRepository.getRecyclerViewData(exampleItems)
    }
}