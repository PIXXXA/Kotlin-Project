package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.SecondViewModelRepository

class SecondFragmentViewModelFactory(private val secondViewModelRepository: SecondViewModelRepository, private val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SecondViewModelRepository::class.java, ResourceProvider::class.java)
                .newInstance(secondViewModelRepository, resourceProvider)
    }
}