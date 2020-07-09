package com.example.weather.retrofit;

import com.example.weather.POJO.ConsolidatedWeather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("3534")
    Call<ConsolidatedWeather> getMontrealWeatherData();
}
