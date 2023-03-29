package com.example.WeatherApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getWeatherSkopje(
        @Query("key") apiKey : String,
        @Query("q") City : String,
        @Query("aqi") aqi : String) : Response<Weather>

}