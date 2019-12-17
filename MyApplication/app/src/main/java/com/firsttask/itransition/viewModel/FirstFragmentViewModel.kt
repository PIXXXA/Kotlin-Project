package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.RecyclerViewEntity
import java.util.*

class FirstFragmentViewModel : ViewModel() {
    val exampleItems = ArrayList<RecyclerViewEntity>()

    fun viewModelMethod(){

        exampleItems.add(RecyclerViewEntity("25.01.2019", "52,27"))
        exampleItems.add(RecyclerViewEntity("26.01.2019", "29,52"))
    }
}