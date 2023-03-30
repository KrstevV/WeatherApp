package com.example.WeatherApp.presentation

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.WeatherApp.forecastData.Forecast
import com.example.WeatherApp.data.Weather
import com.example.WeatherApp.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(var repository: WeatherRepository) : ViewModel(){

    val resp = MutableLiveData<Weather>()
    val resp2 = MutableLiveData<Forecast>()



    fun getWheaterSkop(apiKey : String, City : String , aqi : String, main : MainActivity) = viewModelScope.launch {
        repository.getWheaterSko(apiKey,City,aqi).let { response ->
        if (response.isSuccessful) {
            resp.value = response.body()
        } else {
            Log.d("sdfs", "adsd")
            Toast.makeText(main.applicationContext, "Write correctly City Name" , Toast.LENGTH_SHORT).show()
        }
        }
    }

    fun getForecastSkop(apiKey : String, City: String, day : Int,
    aqi: String, alert : String) =
        viewModelScope.launch {
            repository.getForcastSko(apiKey,City,day,aqi,alert).let {response ->
                resp2.value = response.body()
            }

        }



}