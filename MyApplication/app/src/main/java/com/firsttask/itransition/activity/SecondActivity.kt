package com.firsttask.itransition.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.firsttask.itransition.*
import com.firsttask.itransition.adapter.DailyForecasts
import com.firsttask.itransition.adapter.WeatherLocationGSONAdapter
import com.firsttask.itransition.fragment.SecondScreenFragment
import kotlinx.android.synthetic.main.activity_for_second_fragment.*
import retrofit2.Call
import retrofit2.Response

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
        val locationKeyRequest = (application as BaseApplication).accuweatherRetrofit
        val locationCodeRequest = locationKeyRequest.getDailyForecast()?.getLocationCode(KEY, text2)
        locationCodeRequest?.enqueue(object : retrofit2.Callback<WeatherLocationGSONAdapter> {
            override fun onFailure(call: Call<WeatherLocationGSONAdapter>, t: Throwable) {
                Log.d(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<WeatherLocationGSONAdapter>, response: Response<WeatherLocationGSONAdapter>) {
                textView?.text = response.body()?.key

                val weatherKeyRequest = (application as BaseApplication).accuweatherRetrofit
                val weatherRequest = weatherKeyRequest.getDailyForecast()?.getWeather(textView?.text.toString(), KEY)
                weatherRequest?.enqueue(object : retrofit2.Callback<DailyForecasts> {
                    override fun onFailure(call: Call<DailyForecasts>, t: Throwable) {
                        Log.d(TAG, t.localizedMessage)
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onResponse(call: Call<DailyForecasts>, response: Response<DailyForecasts>) {
                        val weatherResponse = response.body()
                        textView3?.text = "${getString(R.string.tempMax)}${weatherResponse?.temp?.maximum.toString()}\n${getString(R.string.date)}${weatherResponse?.date.toString()}\n${getString(R.string.tempMin)}${weatherResponse?.temp?.minimum.toString()}\n"
                    }
                })
            }
        })

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = SecondScreenFragment.newInstance(text1, text2)
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}