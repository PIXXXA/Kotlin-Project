package com.firsttask.itransition;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationCodeRetrofitClass {

    public static final String key = "2JtU9ZiirVH3GqbuRPjATMCMODBSvjia";
    private AccuWeatherClient accuWeatherClient;

    LocationCodeRetrofitClass() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl("http://dataservice.accuweather.com")
                .build();
        accuWeatherClient = retrofit.create(AccuWeatherClient.class);
    }

    public AccuWeatherClient getAccuWeatherClient() {
        return accuWeatherClient;
    }
}
