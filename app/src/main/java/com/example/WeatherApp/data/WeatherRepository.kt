package com.example.WeatherApp.data

import com.example.WeatherApp.domain.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(var api : WeatherApi) {


    suspend fun getWheaterSko(apiKey : String, ciy : String, aqi : String )
    = withContext(Dispatchers.IO) {
        api.getWeatherSkopje(apiKey, ciy, aqi)
    }

    suspend fun getForcastSko(
        apiKey: String, ciy: String, days : Int,
        aqi : String, alert : String)
    = withContext(Dispatchers.IO) {
        api.getForecastSkopje(apiKey,ciy,days,aqi,alert)
    }



}