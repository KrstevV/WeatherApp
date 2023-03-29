package com.example.WeatherApp.domain

import com.example.WeatherApp.Forecast
import com.example.WeatherApp.ForecastX
import com.example.WeatherApp.Forecastday
import com.example.WeatherApp.data.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getWeatherSkopje(
        @Query("key") apiKey : String,
        @Query("q") City : String,
        @Query("aqi") aqi : String) : Response<Weather>

    @GET("v1/forecast.json")
    suspend fun getForecastSkopje(
        @Query("key") apiKey : String,
        @Query("q") City : String,
        @Query("days") day : Int,
        @Query("aqi") aqi : String,
        @Query ("alerts") alert : String) : Response<Forecast>
}