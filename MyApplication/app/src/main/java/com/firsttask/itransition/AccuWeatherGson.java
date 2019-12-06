package com.firsttask.itransition;

import com.google.gson.annotations.SerializedName;

public class AccuWeatherGson {
    @SerializedName("Key")
    private String Key;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
