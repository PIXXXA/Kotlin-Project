package com.firsttask.itransition.repository

import com.firsttask.itransition.DATE_FORMAT
import com.firsttask.itransition.entity.City
import java.text.SimpleDateFormat
import java.util.*

class CityRepository{

    fun getRecyclerViewData(exampleItems : ArrayList<City>) {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        val getDate = dateFormat.format(Date())
        exampleItems.add(City(getDate, "52,27"))
        exampleItems.add(City(getDate, "29,52"))
    }
}