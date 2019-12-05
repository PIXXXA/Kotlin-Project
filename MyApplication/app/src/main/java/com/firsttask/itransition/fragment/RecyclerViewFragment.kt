package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.firsttask.itransition.R
import com.firsttask.itransition.adapter.RecyclerViewAdapter
import com.firsttask.itransition.entity.RecyclerViewEntity

import java.util.ArrayList

class RecyclerViewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapt: RecyclerView.Adapter<*>
        val layoutManager: RecyclerView.LayoutManager

        val exampleItems = ArrayList<RecyclerViewEntity>()

        exampleItems.add(RecyclerViewEntity("25.01.2019", "1* C"))
        exampleItems.add(RecyclerViewEntity("26.01.2019", "-1* C"))

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        adapt = RecyclerViewAdapter(exampleItems, context)
        recyclerView.adapter = adapt
        recyclerView.layoutManager = layoutManager

    }
}


