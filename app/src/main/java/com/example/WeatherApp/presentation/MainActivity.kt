package com.example.WeatherApp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.WeatherApp.forecastData.Forecastday
import com.example.WeatherApp.databinding.ActivityMainBinding
import com.example.WeatherApp.di.Constants
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewM : WeatherViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    lateinit var AdapterR : Adapter

    var asdas : String = "sdfsdad"
    var sdfsdfs : String = "sdfqwe"
    var sgfdsf : Int = 123
    var sdfsfs : String = "qweqq"
    var sdfdsfs: String = "sdfsfsfs"
    var sdfdssdfs : Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var forecas = mutableListOf<Forecastday>()
        AdapterR = Adapter(forecas)
        binding.recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recView.adapter = AdapterR

        viewM.getWheaterSkop(Constants.API_KEY, "Strumica", "no", this)
        viewM.getForecastSkop(Constants.API_KEY, "Strumica", 9, "no", "no")

        binding.button2.setOnClickListener {
            viewM.getWheaterSkop(Constants.API_KEY, binding.editTextCity.text.toString(), "no", this)
            viewM.getForecastSkop(Constants.API_KEY, binding.editTextCity.text.toString(), 9, "no", "no")
        }
       viewM.resp.observe(this, { response ->
           binding.apply {
               City.text = response.location.name
               Country.text = response.location.country
               Ceu.text = response.current.temp_c.toInt().toString() + "\u00B0"
               textViewHumidity.text = response.current.humidity.toString() + "" + "%"
               textViewWind.text = response.current.wind_kph.toString() + "/kmh"
               Picasso.get().load("https://" + response.current.condition.icon).into(binding.imageView4)
           }
       })
        viewM.resp2.observe(this, Observer {forecast ->
            forecast?.forecast?.forecastday?.let {
                it.removeFirst()
                AdapterR.setForecast(it)
            }
        })
    }
}