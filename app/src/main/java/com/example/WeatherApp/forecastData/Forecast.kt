package com.example.WeatherApp.forecastData

data class Forecast(
    val current: Current,
    val forecast: ForecastX,
    val location: Location
)