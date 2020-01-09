package com.firsttask.itransition.repository

import com.firsttask.itransition.DATE_FORMAT
import com.firsttask.itransition.entity.RecyclerViewEntity
import java.text.SimpleDateFormat
import java.util.*

class FirstViewModelRepository{

    fun getRecyclerViewData(exampleItems : ArrayList<RecyclerViewEntity>) {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        val getDate = dateFormat.format(Date())
        exampleItems.add(RecyclerViewEntity(getDate, "52,27"))
        exampleItems.add(RecyclerViewEntity(getDate, "29,52"))
    }
}