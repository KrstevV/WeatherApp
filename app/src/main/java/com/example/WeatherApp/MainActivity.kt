package com.example.WeatherApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.WeatherApp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewM : WeatherViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewM.getWheaterSkop(Constants.API_KEY, "Valandovo", "no", this)


        binding.button2.setOnClickListener {
            viewM.getWheaterSkop(Constants.API_KEY, binding.editTextCity.text.toString(), "no", this)
        }
       viewM.resp.observe(this, { response ->
           binding.apply {
               City.text = response.location.name
               Country.text = response.location.country
               Ceu.text = response.current.temp_c.toInt().toString() + "C"
               Cloud.text = response.current.cloud.toString() + " " + "%"
               Humidity.text = response.current.humidity.toString() + " " + "%"
               Preasure.text = response.current.wind_kph.toString() + "/" + "kmh"
               Picasso.get().load(response.current.condition.icon).into(imageView4)

           }
       })




    }
}