package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.firsttask.itransition.BaseApplication
import com.firsttask.itransition.R
import com.firsttask.itransition.STR1
import com.firsttask.itransition.STR2
import com.firsttask.itransition.databinding.ActivityForSecondFragmentBinding
import com.firsttask.itransition.viewModel.WeatherViewModel
import com.firsttask.itransition.viewModel.viewModelFactory.WeatherFactory
import kotlinx.android.synthetic.main.fragment_weather.*
import javax.inject.Inject

class WeatherFragment : Fragment() {

    private lateinit var binding: ActivityForSecondFragmentBinding

    @Inject
    lateinit var viewModelFactory: WeatherFactory

    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {

            val dateAdapter = arguments?.getString(STR1)
            val coordinateAdapter = arguments?.getString(STR2)

            viewModel = ViewModelProvider(this, viewModelFactory)
                    .get(WeatherViewModel::class.java)

            viewModel.dateAdapter.value = dateAdapter
            viewModel.getRequest(coordinateAdapter)
            binding.lifecycleOwner = this
            binding.secondViewModel = viewModel
            swipetorefresh.setOnRefreshListener {
                viewModelRefresh(coordinateAdapter)
                swipetorefresh.isRefreshing = false
            }
        }
    }

    fun viewModelRefresh(coordinateAdapter: String?) {
        viewModel.coordinateAdapter.value = ""
        viewModel.bodyKey.value = ""
        viewModel.weather.value = ""
        viewModel.getRequest(coordinateAdapter)
    }

    companion object {
        fun newInstance(SomeText1: String, someText2: String): WeatherFragment {
            val secondScreenFragment = WeatherFragment()
            val bundle = Bundle()
            bundle.putString(STR1, SomeText1)
            bundle.putString(STR2, someText2)
            secondScreenFragment.arguments = bundle
            return secondScreenFragment
        }
    }
}