package com.firsttask.itransition.viewModel

import androidx.lifecycle.ViewModel
import com.firsttask.itransition.entity.City
import com.firsttask.itransition.repository.CityRepository
import java.util.*

class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {
    val exampleItems = ArrayList<City>()

    fun getRecyclerView() {
        cityRepository.getRecyclerViewData(exampleItems)
    }
}