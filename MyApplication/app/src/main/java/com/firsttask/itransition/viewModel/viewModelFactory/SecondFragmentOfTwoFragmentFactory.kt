package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.repository.SecondFragmentOftwoFragmentViewModelRepository

class SecondFragmentOfTwoFragmentFactory (private val secondFragmentOftwoFragmentViewModelRepository: SecondFragmentOftwoFragmentViewModelRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SecondFragmentOftwoFragmentViewModelRepository::class.java)
                .newInstance(secondFragmentOftwoFragmentViewModelRepository)
    }
}