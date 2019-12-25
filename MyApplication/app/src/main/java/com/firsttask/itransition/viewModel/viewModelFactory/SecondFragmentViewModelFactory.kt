package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.rest.RestClient

class SecondFragmentViewModelFactory(private val restClient: RestClient, private val coordAdapter: String, private val dateAdapter: String,
                                     private val resourceProvider: ResourceProvider)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestClient::class.java, String::class.java, String::class.java, ResourceProvider::class.java)
                .newInstance(restClient, coordAdapter, dateAdapter, resourceProvider)
    }
}