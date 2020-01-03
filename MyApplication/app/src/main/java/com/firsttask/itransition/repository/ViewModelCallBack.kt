package com.firsttask.itransition.repository

import com.firsttask.itransition.rest.model.WeatherResponse

interface ViewModelCallBack {
    fun onSucess(stringBuilder:WeatherResponse , locationKey :String?)
}