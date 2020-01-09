package com.firsttask.itransition.dagger

import com.firsttask.itransition.BASE_URL
import com.firsttask.itransition.rest.service.WeatherService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun httpRequest(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        return client
    }

    @Provides
    @Singleton
    fun retrofitBuild(client: OkHttpClient): Retrofit{
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl(BASE_URL)
                .client(client)
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun serviceCreate(retrofit: Retrofit): WeatherService {
        val weatherService = retrofit.create(WeatherService::class.java)
        return weatherService
    }
}