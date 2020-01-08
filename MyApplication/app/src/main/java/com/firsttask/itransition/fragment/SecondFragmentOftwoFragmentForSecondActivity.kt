package com.firsttask.itransition.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.firsttask.itransition.R

/**
 * A simple [Fragment] subclass.
 */
class SecondFragmentOftwoFragmentForSecondActivity : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_fragment_oftwo_fragment_for_second, container, false)
    }


}
