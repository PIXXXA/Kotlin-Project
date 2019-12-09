package com.firsttask.itransition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccuWeatherClient {
    @GET("/locations/v1/cities/geoposition/search")
    Call<AccuWeatherGsonLocation> getLocationCode(@Query("apikey") String apiKey , @Query("q") String q);

    @GET("forecasts/v1/daily/1day/{location}")
    Call<DailyForecasts> getWeather(@Query("location") String location, @Query("apikey") String apiKey1);
}
