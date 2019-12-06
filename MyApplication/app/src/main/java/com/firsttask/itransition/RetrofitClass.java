package com.firsttask.itransition;

import com.firsttask.itransition.activity.SecondActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private final String baseUrl= "http://dataservice.accuweather.com";
    private Gson gson = new GsonBuilder().create();
    private final String key = "VsjRvwV3ZtcUFlMdDiZSeQW3u8f4Ol0m";

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseUrl)
            .build();

    private AccuWeatherClient accuWeatherClient = retrofit.create(AccuWeatherClient.class);

    SecondActivity secondActivity = new SecondActivity();

    Call<Object> call = accuWeatherClient.getLocationCode(key, );
}
