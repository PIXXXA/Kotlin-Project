package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.rest.RestClient

class SecondFragmentViewModelFactory(val restClient: RestClient,val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestClient::class.java, ResourceProvider::class.java)
                .newInstance(restClient, resourceProvider)
    }
}