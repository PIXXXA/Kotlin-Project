package com.firsttask.itransition;

import android.app.Application;

import com.firsttask.itransition.rest.RestClient;

public class BaseApplication extends Application {
    private RestClient restClient;
    @Override
    public void onCreate() {
        super.onCreate();
        restClient = new RestClient();
    }
    public RestClient getRestClient() {
        return restClient;
    }
}
