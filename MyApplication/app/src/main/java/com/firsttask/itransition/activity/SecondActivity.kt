package com.firsttask.itransition.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.firsttask.itransition.*
import com.firsttask.itransition.fragment.SecondScreenFragment
import com.firsttask.itransition.rest.model.ApiResponse
import com.firsttask.itransition.rest.model.WeatherResponse
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
        val locationKeyRequest = (application as BaseApplication).restClient
        val locationCodeRequest = locationKeyRequest.getDailyForecast()?.getLocationCode(KEY, text2)
        locationCodeRequest?.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                textView?.text = response.body()?.key

                val weatherKeyRequest = (application as BaseApplication).restClient
                val weatherRequest = weatherKeyRequest.getDailyForecast()?.getWeather(textView?.text.toString(), KEY)
                weatherRequest?.enqueue(object : retrofit2.Callback<WeatherResponse> {
                    override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                        Log.d(TAG, t.localizedMessage)
                    }

                    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                        val weatherResponse = response.body()

                        val stringBuilder = "${getString(R.string.temp)}${weatherResponse?.dailyForecasts?.temperature}" +
                                "\n${getString(R.string.date)}${weatherResponse?.dailyForecasts?.nowDate}"
                        textView3?.text = stringBuilder
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

