package com.firsttask.itransition

import com.google.gson.annotations.SerializedName

class DailyForecasts {
    @SerializedName("Temperature")
    var temp: Temperature? = null
    @SerializedName("Date")
    var date: String? = null
}

class Temperature {
    @SerializedName("Minimum")
    var minimum: Minimum? = null
    @SerializedName("Maximum")
    var maximum: Maximum? = null
}

class Minimum {
    @SerializedName("Value")
    var valueMin: Float = 0.toFloat()
    @SerializedName("Unit")
    var unitMin: String? = null
    @SerializedName("UnitType")
    var unitTypeMin: Float = 0.toFloat()
}

class Maximum {
    @SerializedName("Value")
    var valueMax: Float = 0.toFloat()
    @SerializedName("Unit")
    var unitMax: String? = null
    @SerializedName("UnitType")
    var unitTypeMax: Float = 0.toFloat()
}