package com.firsttask.itransition.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.*
import com.firsttask.itransition.activity.WeatherActivity
import com.firsttask.itransition.entity.Weather
import kotlinx.android.synthetic.main.history_recycler_view_item.view.*

class WeatherAdapter(private val recyclerViewEntityItem: ArrayList<Weather>) : RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val v=LayoutInflater.from(parent.context)
                    .inflate(R.layout.history_recycler_view_item,parent,false)
            return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerViewEntity = recyclerViewEntityItem[position]
        holder.binding(recyclerViewEntity)
    }

    override fun getItemCount(): Int {
        return recyclerViewEntityItem.size
    }

    class MyViewHolder constructor(view:View) : RecyclerView.ViewHolder(view){

        fun binding(weather: Weather){
            itemView.currentDateTextView.text = weather.dateWeather
            itemView.coordinateTextView.text = weather.coordinateWeather
            itemView.bodyKeyTextView.text = weather.bodyKeyWeather
            itemView.weatherTextView.text = weather.allWeather

            itemView.setOnClickListener{v->
                val intent = Intent(v.context , WeatherActivity::class.java)
                intent.putExtra(CURRENT_DATE , weather.dateWeather)
                intent.putExtra(COORDINATE, weather.coordinateWeather)
                intent.putExtra(BODY_KEY , weather.bodyKeyWeather)
                intent.putExtra(WEATHER_DATA , weather.allWeather)
                v.context.startActivity(intent)
            }
        }
    }
}