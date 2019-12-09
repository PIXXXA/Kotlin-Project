package com.firsttask.itransition;

import android.app.Application;

public class BaseApplication extends Application{
    public LocationCodeRetrofitClass locationCodeRetrofitClass;
    public WeatherRetrofitClass weatherRetrofitClass;

    @Override
    public void onCreate() {
        super.onCreate();
        locationCodeRetrofitClass = new LocationCodeRetrofitClass();
        weatherRetrofitClass = new WeatherRetrofitClass();
    }

    public LocationCodeRetrofitClass getLocationCodeRetrofitClass() { return locationCodeRetrofitClass; }

    public WeatherRetrofitClass getWeatherRetrofitClass() {
        return weatherRetrofitClass;
    }
}
