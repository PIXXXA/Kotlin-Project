package com.firsttask.itransition

import android.content.Context

class ResourceProvider(val context: Context) {

    fun getString(resId: Int): String? {
        return context.getString(resId)
    }
}