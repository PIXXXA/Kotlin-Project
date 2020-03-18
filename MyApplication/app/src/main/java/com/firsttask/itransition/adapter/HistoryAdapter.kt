package com.firsttask.itransition.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.R
import com.firsttask.itransition.entity.Weather
import kotlinx.android.synthetic.main.history_recycler_view_item.view.*

class HistoryAdapter(private val recyclerViewEntityItem: ArrayList<Weather>) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.history_recycler_view_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerViewEntity = recyclerViewEntityItem[position]
        holder.binding(recyclerViewEntity)
    }

    override fun getItemCount(): Int {
        return recyclerViewEntityItem.size
    }

    class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        fun binding(weather: Weather) {
            itemView.currentDateTextView.text = weather.dateWeather
            itemView.coordinateTextView.text = weather.coordinateWeather
            itemView.bodyKeyTextView.text = weather.bodyKeyWeather
            itemView.weatherTextView.text = weather.allWeather
        }
    }
}