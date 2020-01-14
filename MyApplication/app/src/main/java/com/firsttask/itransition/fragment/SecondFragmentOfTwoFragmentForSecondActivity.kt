package com.firsttask.itransition.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.R
import com.firsttask.itransition.adapter.RecyclerViewAdapterForSecondActivity
import com.firsttask.itransition.entity.RecyclerViewEntityForSecondActivity
import com.firsttask.itransition.viewModel.SecondFragmentOfTwoFragmentViewModel
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentOfTwoFragmentFactory
import kotlinx.android.synthetic.main.recycler_view_for_second_fragment.*
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

        viewModel.getRecyclerViewData()
        val layoutManager = LinearLayoutManager(context)
        updateAdapter(arrayListOf())
        viewModel.exampleItems.observe(viewLifecycleOwner ,  Observer<ArrayList<RecyclerViewEntityForSecondActivity>> {
            updateAdapter(it)
        })
        recycler_view_second_fragment.layoutManager = layoutManager
    }

    private fun updateAdapter(list: ArrayList<RecyclerViewEntityForSecondActivity>) {
        val recyclerViewAdapterForSecondActivity = RecyclerViewAdapterForSecondActivity(list)
        recycler_view_second_fragment.adapter = recyclerViewAdapterForSecondActivity
    }

    companion object {
        fun newInstance(): SecondFragmentOfTwoFragmentForSecondActivity {
            return SecondFragmentOfTwoFragmentForSecondActivity()
        }
    }

}