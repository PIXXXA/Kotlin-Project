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

class SecondScreenFragment : Fragment() {

    private lateinit var binding: ActivityForSecondFragmentBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_for_second_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {

            val textSTR1 = arguments?.getString(STR1)
            val textSTR2 = arguments?.getString(STR2)

            val sdf = activity?.application as BaseApplication

            val viewModelFactory = SecondFragmentViewModelFactory(sdf.restClient, textSTR2.toString(), textSTR1.toString(), sdf.secondFragmentResourceProvider)
            val viewModel = ViewModelProviders.of(this, viewModelFactory)
                    .get(SecondFragmentViewModel::class.java)
            binding.lifecycleOwner = this

            binding.secondViewModel = viewModel

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