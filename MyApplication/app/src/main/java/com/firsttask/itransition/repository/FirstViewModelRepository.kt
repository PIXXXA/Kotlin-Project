package com.firsttask.itransition.repository

import com.firsttask.itransition.entity.RecyclerViewEntity
import java.text.SimpleDateFormat
import java.util.*

class FirstViewModelRepository{

    fun getRecyclerViewData(exampleItems : ArrayList<RecyclerViewEntity>) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm" , Locale.getDefault())
        val getDate = dateFormat.format(Date())
        exampleItems.add(RecyclerViewEntity(getDate, "52,27"))
        exampleItems.add(RecyclerViewEntity(getDate, "29,52"))
    }
}