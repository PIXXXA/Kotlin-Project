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
import com.firsttask.itransition.adapter.RecyclerViewAdapterForSecondActivity
import com.firsttask.itransition.viewModel.SecondFragmentOfTwoFragmentViewModel
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentOfTwoFragmentFactory
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondFragmentOfTwoFragmentForSecondActivity : Fragment() {

    @Inject
    lateinit var secondFragmentOfTwoFragmentFactory: SecondFragmentOfTwoFragmentFactory

    private lateinit var viewModel:SecondFragmentOfTwoFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view_for_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(this , secondFragmentOfTwoFragmentFactory)
                .get(SecondFragmentOfTwoFragmentViewModel::class.java)

        viewModel.getRecyclerView()
        val layoutManager:RecyclerView.LayoutManager
        val recyclerView:RecyclerView = view.findViewById(R.id.recycler_view_second_fragment)
        layoutManager = LinearLayoutManager(activity)
        val adapt = RecyclerViewAdapterForSecondActivity(viewModel.exampleItems)
        recyclerView.adapter = adapt
        recyclerView.layoutManager = layoutManager
    }

    companion object {
        fun newInstance(): SecondFragmentOfTwoFragmentForSecondActivity {
            return SecondFragmentOfTwoFragmentForSecondActivity()
        }
    }

}