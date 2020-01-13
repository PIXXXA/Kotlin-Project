package com.firsttask.itransition.repository

import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity

interface HistoryCallBack {
    fun setRecyclerView(exampleItem: ArrayList<RecyclerViewEntityForSecondActivity>)
}