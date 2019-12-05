package com.firsttask.itransition.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.R
import com.firsttask.itransition.activity.SecondActivity
import com.firsttask.itransition.entity.RecyclerViewEntity
import java.util.*

class RecyclerViewAdapter(private val recyclerViewEntityItem: ArrayList<RecyclerViewEntity>, private val context: Context?) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView
        val textView2: TextView

        init {
            textView1 = view.findViewById(R.id.text1)
            textView2 = view.findViewById(R.id.text2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerViewEntity = recyclerViewEntityItem[position]

        holder.textView1.text = recyclerViewEntity.data
        holder.textView2.text = recyclerViewEntity.temp

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, SecondActivity::class.java)
            intent.putExtra("Data", recyclerViewEntity.data)
            intent.putExtra("Temp", recyclerViewEntity.temp)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return recyclerViewEntityItem.size
    }
}
