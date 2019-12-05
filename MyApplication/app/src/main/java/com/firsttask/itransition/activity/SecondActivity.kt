package com.firsttask.itransition.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView

import com.firsttask.itransition.R
import com.firsttask.itransition.fragment.SecondScreenFragment

class SecondActivity : AppCompatActivity() {

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var text1 = ""
        var text2 = ""
        val intent = intent
        if (intent != null) {
            text1 = intent.getStringExtra(DATA)
            text2 = intent.getStringExtra(TEMP)
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentTransaction1 = SecondScreenFragment.newInstance(text1, text2)
        fragmentTransaction.replace(R.id.frameLayout, fragmentTransaction1)
        fragmentTransaction.commit()
    }

    companion object {
        private val DATA = "Data"
        private val TEMP = "Temp"
    }
}

