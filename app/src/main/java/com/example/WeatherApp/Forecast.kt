package com.example.WeatherApp

data class Forecast(
    val current: Current,
    val forecast: ForecastX,
    val location: Location
)