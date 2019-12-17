package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firsttask.itransition.*
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
import com.firsttask.itransition.viewModel.SecondFragmentViewModel
import kotlinx.android.synthetic.main.activity_for_second_fragment.*
import retrofit2.Call
import retrofit2.Response

class SecondScreenFragment : Fragment(){

    private lateinit var model: SecondFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.activity_for_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {

            model = ViewModelProviders.of(this).get(SecondFragmentViewModel::class.java)
            model.a1 = arguments?.getString(STR1)
            model.a2 = arguments?.getString(STR2)
            textView1.text = model.a1
            textView2.text = model.a2
            model.getWeather()
            val bodeKeyObserver = Observer<String> { newName -> textView.text = newName }
            model.getbodyKey().observe(this , bodeKeyObserver)
            val weatherObserver = Observer<String> { newName -> textView3.text = newName }
            model.getweather().observe(this , weatherObserver)
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