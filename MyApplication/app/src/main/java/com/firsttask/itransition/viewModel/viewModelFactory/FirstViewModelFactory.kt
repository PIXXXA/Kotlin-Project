package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.repository.FirstViewModelRepository

class FirstViewModelFactory(private val firstViewModelRepository: FirstViewModelRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FirstViewModelRepository::class.java)
                .newInstance(firstViewModelRepository)
    }
}