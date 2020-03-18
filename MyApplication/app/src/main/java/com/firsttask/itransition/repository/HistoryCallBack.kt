package com.firsttask.itransition.repository

import com.firsttask.itransition.entity.Weather

interface HistoryCallBack {
    fun setRecyclerViewData(exampleItem: ArrayList<Weather>)
}