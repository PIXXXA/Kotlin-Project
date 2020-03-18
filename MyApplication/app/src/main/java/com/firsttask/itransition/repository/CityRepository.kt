package com.firsttask.itransition.repository

import com.firsttask.itransition.DATE_FORMAT
import com.firsttask.itransition.entity.City
import java.text.SimpleDateFormat
import java.util.*

class CityRepository{

    fun getRecyclerViewData(exampleItems : ArrayList<City>) {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        val getDate = dateFormat.format(Date())
        exampleItems.add(City(getDate, "53.900238, 27.554906", "Minsk"))
        exampleItems.add(City(getDate, "53.941260, 30.273912", "Mogilev"))
        exampleItems.add(City(getDate, "55.192711, 30.205762", "Vitebsk"))
        exampleItems.add(City(getDate, "53.719061, 23.833825", "Grodno"))
        exampleItems.add(City(getDate, "52.505774, 31.040856", "Gomel"))
        exampleItems.add(City(getDate, "52.082461, 23.855798", "Brest"))
    }
}