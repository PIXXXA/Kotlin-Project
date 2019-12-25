package com.firsttask.itransition.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firsttask.itransition.DATA
import com.firsttask.itransition.R
import com.firsttask.itransition.TEMP
import com.firsttask.itransition.fragment.SecondScreenFragment

class SecondActivity : AppCompatActivity() {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var text2 = ""
        var text1 = ""

        if (intent != null) {
            text1 = intent.getStringExtra(DATA)
            text2 = intent.getStringExtra(TEMP)
        }

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = SecondScreenFragment.newInstance(text1, text2)
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}

