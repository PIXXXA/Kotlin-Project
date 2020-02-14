package com.firsttask.individualtask.fragment.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.firsttask.individualtask.Application
import com.firsttask.individualtask.R
import com.firsttask.individualtask.databinding.WeatherFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: WeatherFactory
    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<WeatherFragmentBinding>(
            inflater, R.layout.weather_fragment, container, false
        ).run {
            lifecycleOwner = this@WeatherFragment
            viewModel = this@WeatherFragment.viewModel
            root
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val longitude: String? = arguments?.getString("Longitude")
        val latitude: String? = arguments?.getString("Latitude")
        viewModel.currentLocation(latitude, longitude)
    }

    companion object {
        fun newInstance() = WeatherFragment()
    }
}