package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.R
import com.firsttask.itransition.STR1
import com.firsttask.itransition.STR2
import com.firsttask.itransition.databinding.ActivityForSecondFragmentBinding
import com.firsttask.itransition.viewModel.SecondFragmentViewModel
import com.firsttask.itransition.viewModel.viewModelFactory.SecondFragmentViewModelFactory
import kotlinx.android.synthetic.main.activity_for_second_fragment.*
import javax.inject.Inject

class SecondScreenFragment : Fragment() {

    private lateinit var binding: ActivityForSecondFragmentBinding

    @Inject
    var viewModelFactory: SecondFragmentViewModelFactory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_for_second_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {

            val dateAdapter = arguments?.getString(STR1)
            val coordinateAdapter = arguments?.getString(STR2)

            val viewModel = ViewModelProviders.of(this, viewModelFactory)
                    .get(SecondFragmentViewModel::class.java)
            viewModel.dateAdapter = dateAdapter
            viewModel.getRequest(coordinateAdapter)
            binding.lifecycleOwner = this
            binding.secondViewModel = viewModel



            swipetorefresh.setOnRefreshListener {
//                val cloneDateAdapter = viewModel.dateAdapter
//                val cloneCoordinateAdapter = viewModel.coordinateAdapter
//                val cloneBodyKey = viewModel.bodyKey.value
//                val cloneWeather = viewModel.weather.value
//
//                viewModel.dateAdapter = ""
//                viewModel.coordinateAdapter = ""
//                viewModel.bodyKey.value = ""
//                viewModel.weather.value = ""
//
//                viewModel.dateAdapter = cloneDateAdapter
//                viewModel.coordinateAdapter = cloneCoordinateAdapter
//                viewModel.bodyKey.value = cloneBodyKey
//                viewModel.weather.value = cloneWeather

                viewModel.getRequest(coordinateAdapter)

                swipetorefresh.isRefreshing = false
            }

        }
    }
    companion object {
        fun newInstance(SomeText1: String, someText2: String): SecondScreenFragment {
            val secondScreenFragment = SecondScreenFragment()
            val bundle = Bundle()
            bundle.putString(STR1, SomeText1)
            bundle.putString(STR2, someText2)
            secondScreenFragment.arguments = bundle
            return secondScreenFragment
        }
    }
}