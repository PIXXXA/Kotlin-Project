package com.firsttask.itransition.dagger

import android.content.Context
import com.firsttask.itransition.ResourceProvider
import com.firsttask.itransition.rest.RestClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun getRestClient(): RestClient {
        return RestClient()
    }

    @Provides
    @Singleton
    fun getResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context)
    }
}