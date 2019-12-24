package com.firsttask.itransition

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton  @Inject constructor
class ResourceProvider(val context: Context) {

    fun getString(resId: Int): String? {
        return context.getString(resId)
    }

    fun getString(resId: Int, value: String?): String? {
        return context.getString(resId, value)
    }
}