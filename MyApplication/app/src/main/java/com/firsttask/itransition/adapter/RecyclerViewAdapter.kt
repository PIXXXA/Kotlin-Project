package com.firsttask.itransition.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.R
import com.firsttask.itransition.activity.SecondActivity
import com.firsttask.itransition.entity.RecyclerViewEntity
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.util.*

class RecyclerViewAdapter(private val recyclerViewEntityItem: ArrayList<RecyclerViewEntity>)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerViewEntity = recyclerViewEntityItem[position]
        holder.bind(recyclerViewEntity)
    }

    override fun getItemCount(): Int {
        return recyclerViewEntityItem.size
    }

    class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(recyclerViewEntity: RecyclerViewEntity) {
            itemView.text1.text = recyclerViewEntity.data
            itemView.text2.text = recyclerViewEntity.temp

            itemView.setOnClickListener { v ->
                val intent = Intent(v.context, SecondActivity::class.java)
                intent.putExtra("Data", recyclerViewEntity.data)
                intent.putExtra("Temp", recyclerViewEntity.temp)
                v.context.startActivity(intent)
            }
        }
    }
}
