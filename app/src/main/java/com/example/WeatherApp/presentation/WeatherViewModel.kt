package com.example.WeatherApp.presentation

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.WeatherApp.data.Weather
import com.example.WeatherApp.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(var repository: WeatherRepository) : ViewModel(){

    val resp = MutableLiveData<Weather>()


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


}