package com.example.WeatherApp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.WeatherApp.Forecast
import com.example.WeatherApp.Forecastday
import com.example.WeatherApp.R
import com.example.WeatherApp.data.Current
import com.example.WeatherApp.data.Weather
import com.squareup.picasso.Picasso

class Adapter (var vh : MutableList<Forecastday>): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var img = itemview.findViewById<ImageView>(R.id.imageView)
        var txt = itemview.findViewById<TextView>(R.id.textView4)
        var txt1 = itemview.findViewById<TextView>(R.id.textView9)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent , false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vh.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var position = vh.get(position)
        holder.txt1.text = position.date.drop(5)
        holder.txt.text = position.day.avgtemp_c.toString() + "" + "C"
        Picasso.get().load("https://" + position.day.condition.icon).into(holder.img)

    }

    fun setForecast(cast : MutableList<Forecastday>) {
        this.vh = cast
        notifyDataSetChanged()

    }

}