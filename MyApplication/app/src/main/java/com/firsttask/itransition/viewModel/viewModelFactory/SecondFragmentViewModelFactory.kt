package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.repository.ViewModelRepository

class SecondFragmentViewModelFactory(private val viewModelRepository: ViewModelRepository, private val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ViewModelRepository::class.java, ResourceProvider::class.java)
                .newInstance(viewModelRepository, resourceProvider)
    }
}