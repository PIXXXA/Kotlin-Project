package com.firsttask.itransition.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.firsttask.itransition.R

class SecondFragmentOfTwoFragmentForSecondActivity : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second_fragment_oftwo_fragment_for_second, container, false)
    }


}
