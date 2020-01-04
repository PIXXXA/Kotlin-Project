package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.R
import com.firsttask.itransition.adapter.RecyclerViewAdapter
import com.firsttask.itransition.viewModel.FirstFragmentViewModel
import com.firsttask.itransition.viewModel.SecondFragmentViewModel
import com.firsttask.itransition.viewModel.viewModelFactory.FirstViewModelFactory
import javax.inject.Inject

class RecyclerViewFragment : Fragment() {

    @Inject
    lateinit var firstViewModelFactory: FirstViewModelFactory

    private lateinit var viewModel: FirstFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, firstViewModelFactory)
                .get(FirstFragmentViewModel::class.java)

        viewModel.getRecyclerView()
        val layoutManager: RecyclerView.LayoutManager
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        val adapt = RecyclerViewAdapter(viewModel.exampleItems)
        recyclerView.adapter = adapt
        recyclerView.layoutManager = layoutManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }
}


