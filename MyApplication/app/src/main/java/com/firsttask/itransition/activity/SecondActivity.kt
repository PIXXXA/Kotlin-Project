package com.firsttask.itransition.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView

import com.firsttask.itransition.R
import com.firsttask.itransition.RetrofitClass
import com.firsttask.itransition.fragment.SecondScreenFragment
import java.nio.file.Paths.get

class SecondActivity : AppCompatActivity() {

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var text1 = ""
        var text2 = ""

        if (intent != null) {
            text1 = intent.getStringExtra(DATA)
            text2 = intent.getStringExtra(TEMP)
        }


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = SecondScreenFragment.newInstance(text1, text2)
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    companion object {
        private const val DATA = "Data"
        private const val TEMP = "Temp"
    }
}

