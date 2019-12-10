package com.firsttask.itransition;

import android.app.Application;

import com.firsttask.itransition.retrofit.AccuweatherRetrofit;

public class BaseApplication extends Application {
    private AccuweatherRetrofit accuweatherRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        accuweatherRetrofit = new AccuweatherRetrofit();
    }

    public AccuweatherRetrofit getAccuweatherRetrofit() {
        return accuweatherRetrofit;
    }
}
