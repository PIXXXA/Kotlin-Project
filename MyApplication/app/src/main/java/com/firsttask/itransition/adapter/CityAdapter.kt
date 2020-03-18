package com.firsttask.itransition.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.DATE
import com.firsttask.itransition.R
import com.firsttask.itransition.CITY_COORDINATE
import com.firsttask.itransition.CITY_NAME
import com.firsttask.itransition.activity.WeatherActivity
import com.firsttask.itransition.entity.City
import kotlinx.android.synthetic.main.city_recycler_view_item.view.*
import java.util.*

class CityAdapter(private val cityItem: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.city_recycler_view_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerViewEntity = cityItem[position]
        holder.bind(recyclerViewEntity)
    }

    override fun getItemCount(): Int {
        return cityItem.size
    }

    class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(city: City) {
            itemView.cityDate.text = city.date
            itemView.cityCoordinate.text = city.coordinate
            itemView.cityName.text = city.name

            itemView.setOnClickListener { v ->
                val intent = Intent(v.context, WeatherActivity::class.java)
                intent.putExtra(DATE, city.date)
                intent.putExtra(CITY_COORDINATE, city.coordinate)
                intent.putExtra(CITY_NAME, city.name)
                v.context.startActivity(intent)
            }
        }
    }
}
