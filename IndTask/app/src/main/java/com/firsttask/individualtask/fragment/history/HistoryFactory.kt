package com.firsttask.individualtask.fragment.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firsttask.individualtask.ResourceProvider
import javax.inject.Inject

class HistoryFactory @Inject constructor(
    private val historyRepository: HistoryRepository, private val resourceProvider: ResourceProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            HistoryRepository::class.java,
            ResourceProvider::class.java
        ).newInstance(historyRepository, resourceProvider)
    }
}