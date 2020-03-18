package com.firsttask.itransition.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.DATA
import com.firsttask.itransition.R
import com.firsttask.itransition.TEMP
import com.firsttask.itransition.activity.WeatherActivity
import com.firsttask.itransition.entity.City
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.util.*

class CityAdapter(private val cityItem: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
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
            itemView.text1.text = city.data
            itemView.text2.text = city.temp

            itemView.setOnClickListener { v ->
                val intent = Intent(v.context, WeatherActivity::class.java)
                intent.putExtra(DATA, city.data)
                intent.putExtra(TEMP, city.temp)
                v.context.startActivity(intent)
            }
        }
    }
}
