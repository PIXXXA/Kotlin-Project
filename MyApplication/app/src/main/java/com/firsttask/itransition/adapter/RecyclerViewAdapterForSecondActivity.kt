package com.firsttask.itransition.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.*
import com.firsttask.itransition.activity.SecondActivity
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import kotlinx.android.synthetic.main.recycler_view_item_for_second_fragment.view.*

class RecyclerViewAdapterForSecondActivity(private val recyclerViewEntityItem: ArrayList<RecyclerViewEntityForSecondActivity>) : RecyclerView.Adapter<RecyclerViewAdapterForSecondActivity.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val v=LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item_for_second_fragment,parent,false)
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

        fun binding(recyclerViewEntityForSecondActivity: RecyclerViewEntityForSecondActivity){
            itemView.currentDateTextView.text = recyclerViewEntityForSecondActivity.dateWeather
            itemView.coordinateTextView.text = recyclerViewEntityForSecondActivity.coordinateWeather
            itemView.bodyKeyTextView.text = recyclerViewEntityForSecondActivity.bodyKeyWeather
            itemView.weatherTextView.text = recyclerViewEntityForSecondActivity.allWeather

            itemView.setOnClickListener{v->
                val intent = Intent(v.context , SecondActivity::class.java)
                intent.putExtra(CURRENTDATE , recyclerViewEntityForSecondActivity.dateWeather)
                intent.putExtra(COORDINATE, recyclerViewEntityForSecondActivity.coordinateWeather)
                intent.putExtra(BODYKEY , recyclerViewEntityForSecondActivity.bodyKeyWeather)
                intent.putExtra(WEATHERDATA , recyclerViewEntityForSecondActivity.allWeather)
                v.context.startActivity(intent)
            }

        }
    }

}