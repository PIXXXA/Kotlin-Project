package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.rest.RestClient

class SecondFragmentViewModelFactory(private val restClient: RestClient, var coordAdapter: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestClient::class.java, String::class.java)
                .newInstance(restClient, coordAdapter)

//        if (modelClass.isAssignableFrom(SecondFragmentViewModel::class.java)) {
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
    }
}