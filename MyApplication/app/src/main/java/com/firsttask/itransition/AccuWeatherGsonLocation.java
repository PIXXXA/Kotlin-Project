package com.firsttask.itransition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccuWeatherGsonLocation {
    @SerializedName("Key")
    @Expose
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
