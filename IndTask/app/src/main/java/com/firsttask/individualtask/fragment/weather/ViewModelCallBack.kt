package com.firsttask.individualtask.fragment.weather

import com.firsttask.individualtask.rest.model.WeatherResponse

interface ViewModelCallBack {
    fun onSuccess(stringBuilder: WeatherResponse, locationKey :String?)
}