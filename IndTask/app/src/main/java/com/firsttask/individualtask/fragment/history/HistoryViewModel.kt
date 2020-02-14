package com.firsttask.individualtask.fragment.history

import androidx.lifecycle.ViewModel
import com.firsttask.individualtask.ResourceProvider
import com.firsttask.individualtask.fragment.history.adapter.entity.HistoryRecyclerViewEntity
import java.util.ArrayList

class HistoryViewModel(
    private val historyRepository: HistoryRepository,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    val exampleItems = ArrayList<HistoryRecyclerViewEntity>()

}