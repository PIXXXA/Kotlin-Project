package com.firsttask.itransition.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.repository.HistoryRepository

class HistoryFactory (private val historyRepository: HistoryRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HistoryRepository::class.java)
                .newInstance(historyRepository)
    }
}