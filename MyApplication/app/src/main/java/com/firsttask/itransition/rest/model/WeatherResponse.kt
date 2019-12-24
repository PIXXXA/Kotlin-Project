package com.firsttask.itransition.rest.model

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("DailyForecasts")
    var dailyForecasts: List<DailyForecasts>? = null
}

class DailyForecasts {
    @SerializedName("Temperature")
    var temperature: Temperature? = null
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