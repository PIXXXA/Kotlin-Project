package com.firsttask.itransition.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.firsttask.itransition.*
import com.firsttask.itransition.fragment.HistoryFragment
import com.firsttask.itransition.fragment.WeatherFragment

class WeatherActivity : AppCompatActivity() {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        var coordinateAdapter = ""
        var dateAdapter = ""

        if (intent != null) {
            dateAdapter = intent.getStringExtra(DATA)
            coordinateAdapter = intent.getStringExtra(TEMP)
        }

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = WeatherFragment.newInstance(dateAdapter, coordinateAdapter)
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_second_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        when(id){
            R.id.item_menu ->{
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                val fragment = HistoryFragment.newInstance()
                fragmentTransaction.replace(R.id.frameLayout, fragment)
                fragmentTransaction.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

