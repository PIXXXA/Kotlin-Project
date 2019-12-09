package com.firsttask.itransition.activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.firsttask.itransition.*

import com.firsttask.itransition.fragment.SecondScreenFragment
import retrofit2.Call
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    var text1 = ""

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var text2 = ""
        val weatherCredential : TextView? = findViewById(R.id.textView)
        val weatherData : TextView? = findViewById(R.id.textView3)

        if (intent != null) {
            text1 = intent.getStringExtra(DATA)
            text2 = intent.getStringExtra(TEMP)
        }

        val locationKeyRequest = (application as BaseApplication).locationCodeRetrofitClass
        val locationCodeRequest = locationKeyRequest.accuWeatherClient.getLocationCode(LocationCodeRetrofitClass.key, text2)

        locationCodeRequest.enqueue(object : retrofit2.Callback<AccuWeatherGsonLocation> {
            override fun onFailure(call: Call<AccuWeatherGsonLocation>, t: Throwable) {
                Log.d("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<AccuWeatherGsonLocation>, response: Response<AccuWeatherGsonLocation>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    val stringBuilder = "Key: ${weatherResponse.key!!}"
                    weatherCredential!!.text = stringBuilder
                }
            }
        })

        val weatherRequest = locationKeyRequest.accuWeatherClient.getWeather(LocationCodeRetrofitClass.key , weatherCredential.toString())

        weatherRequest.enqueue(object : retrofit2.Callback<DailyForecasts>{
            override fun onFailure(call: Call<DailyForecasts>, t: Throwable) {
                Log.d("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<DailyForecasts>, response: Response<DailyForecasts>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = "Max temperature: ${weatherResponse.temp!!.maximum}" +
                            "\nDate: ${weatherResponse.date!!}" +
                            "\nTemperature(Min): ${weatherResponse.temp!!.minimum}" +
                            "\n"
                    weatherData!!.text = stringBuilder
                }
            }

        })

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

