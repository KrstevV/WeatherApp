package com.example.WeatherApp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.WeatherApp.forecastData.Forecastday
import com.example.WeatherApp.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

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

        val parser =  SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("EEEE")
        val formattedDate = formatter.format(parser.parse(position.date))


        holder.txt1.text = formattedDate
        holder.txt.text = position.day.avgtemp_c.toString() + "" + "\u00B0"
        Picasso.get().load("https://" + position.day.condition.icon).into(holder.img)

    }

    fun setForecast(cast : MutableList<Forecastday>) {
        this.vh = cast
        notifyDataSetChanged()

    }

}