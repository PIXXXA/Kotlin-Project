package com.firsttask.individualtask.fragment.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.individualtask.R
import com.firsttask.individualtask.fragment.history.adapter.entity.HistoryRecyclerViewEntity

class RecyclerViewAdapter(private val recyclerViewEntityItem: ArrayList<HistoryRecyclerViewEntity>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_recycler_view_items, parent, false)
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
        fun bind(recyclerViewEntity: HistoryRecyclerViewEntity) {
        }
    }
}