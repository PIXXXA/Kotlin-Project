package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.rest.RestClient
import com.firsttask.itransition.ResourceProvider

class SecondFragmentViewModelFactory(private val restClient: RestClient, val coordAdapter: String, val dateAdapter: String,
                                     val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestClient::class.java, String::class.java, String::class.java, ResourceProvider::class.java)
                .newInstance(restClient, coordAdapter, dateAdapter, resourceProvider)
    }
}