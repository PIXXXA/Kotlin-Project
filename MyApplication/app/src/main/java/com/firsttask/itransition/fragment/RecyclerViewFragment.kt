package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.R
import com.firsttask.itransition.adapter.RecyclerViewAdapter
import com.firsttask.itransition.viewModel.FirstFragmentViewModel

class RecyclerViewFragment : Fragment() {

    private lateinit var model: FirstFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProviders.of(this).get(FirstFragmentViewModel::class.java)

        model.viewModelMethod()
        val layoutManager: RecyclerView.LayoutManager
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        val adapt = RecyclerViewAdapter(model.exampleItems)
        recyclerView.adapter = adapt
        recyclerView.layoutManager = layoutManager
    }
}


