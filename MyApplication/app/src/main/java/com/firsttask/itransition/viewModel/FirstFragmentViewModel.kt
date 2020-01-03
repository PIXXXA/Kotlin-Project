package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.RecyclerViewEntity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class FirstFragmentViewModel : ViewModel() {
    val exampleItems = ArrayList<RecyclerViewEntity>()

    fun recyclerViewData() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS" , Locale.getDefault())
        val getDate = dateFormat.format(Date())
        exampleItems.add(RecyclerViewEntity(getDate, "52,27"))
        exampleItems.add(RecyclerViewEntity(getDate, "29,52"))
    }
}