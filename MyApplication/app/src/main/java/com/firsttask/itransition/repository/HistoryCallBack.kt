package com.firsttask.itransition.repository

import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity

interface HistoryCallBack {
    fun setRecyclerViewData(exampleItem: ArrayList<RecyclerViewEntityForSecondActivity>)
}