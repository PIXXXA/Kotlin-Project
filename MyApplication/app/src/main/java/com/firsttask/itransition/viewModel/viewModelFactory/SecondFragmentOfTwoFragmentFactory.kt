package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.db.AppDatabase
import com.firsttask.itransition.repository.SecondFragmentOfTwoFragmentViewModelRepository

class SecondFragmentOfTwoFragmentFactory (private val secondFragmentOfTwoFragmentViewModelRepository: SecondFragmentOfTwoFragmentViewModelRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SecondFragmentOfTwoFragmentViewModelRepository::class.java)
                .newInstance(secondFragmentOfTwoFragmentViewModelRepository)
    }
}