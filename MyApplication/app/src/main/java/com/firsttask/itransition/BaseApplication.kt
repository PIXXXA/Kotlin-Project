package com.firsttask.itransition

import android.app.Application
import com.firsttask.itransition.rest.RestClient

class BaseApplication : Application() {
    val restClient = RestClient()

    val secondFragmentResourceProvider = ResourceProvider(this)
}