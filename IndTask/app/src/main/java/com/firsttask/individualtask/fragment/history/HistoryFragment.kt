package com.firsttask.individualtask.fragment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.individualtask.Application
import com.firsttask.individualtask.R
import com.firsttask.individualtask.fragment.history.adapter.RecyclerViewAdapter
import javax.inject.Inject

class HistoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HistoryFactory
    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.history_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Application.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HistoryViewModel::class.java)

        val layoutManager: RecyclerView.LayoutManager
        val recyclerView: RecyclerView = view.findViewById(R.id.history_recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        val adapt = RecyclerViewAdapter(viewModel.exampleItems)
        recyclerView.adapter = adapt
        recyclerView.layoutManager = layoutManager
    }

    companion object {
        fun newInstance() = HistoryFragment()
    }
}
