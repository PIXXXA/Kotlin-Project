package com.firsttask.itransition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccuWeatherClient {
    @GET("locations/v1/cities/geoposition/search")
    Call<Object> getLocationCode(@Query("apiKey") String apiKey , @Query("q") String q);
}
