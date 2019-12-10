package com.firsttask.itransition.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.firsttask.itransition.R
import com.firsttask.itransition.STR1
import com.firsttask.itransition.STR2
import kotlinx.android.synthetic.main.activity_for_second_fragment.*

class SecondScreenFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_for_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val someText1 = arguments!!.getString(STR1)
            val someText2 = arguments!!.getString(STR2)
            textView1.text = someText1
            textView2.text = someText2
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
