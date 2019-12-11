package com.firsttask.itransition.rest.model

import com.google.gson.annotations.SerializedName

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("Te")
class WeatherResponse {
    @SerializedName("DailyForecasts")
    var dailyForecasts: DailyForecasts? = null
}

class DailyForecasts {
    @SerializedName("Temperature")
    var temperature: ArrayList<Temperature>? = null
    @SerializedName("Date")
    var nowDate: String? = null
}

class Temperature {
    @SerializedName("Minimum")
    var minimum: Minimum? = null
    @SerializedName("Maximum")
    var maximum: Maximum? = null
}

class Minimum {
    @SerializedName("Value")
    var valueMin: Float? = 0.toFloat()
    @SerializedName("Unit")
    var unitMin: String? = null
}

class Maximum {
    @SerializedName("Value")
    var valueMax: Float? = 0.toFloat()
    @SerializedName("Unit")
    var unitMax: String? = null
}