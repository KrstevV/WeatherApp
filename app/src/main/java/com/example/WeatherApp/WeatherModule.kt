package com.example.WeatherApp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object WeatherModule {

    @Provides
    fun baseurl() : String = Constants.BASE_URL


    @Provides
    @Singleton
    fun getWheaterSk() : WeatherApi =
        Retrofit.Builder()
        .baseUrl(baseurl())
        .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

}

