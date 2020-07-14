package com.example.weather.retrofit;

import com.example.weather.POJO.ConsolidatedWeather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("3534")
    Call<ConsolidatedWeather> getMontrealWeatherData();

    @GET("44418")
    Call<ConsolidatedWeather> getLondonWeatherData();

    @GET("2379574")
    Call<ConsolidatedWeather> getChicagoWeatherData();

    @GET("2295402")
    Call<ConsolidatedWeather> getAhmedabadWeatherData();

    @GET("2459115")
    Call<ConsolidatedWeather> getNewyorkWeatherData();

    @GET("4118")
    Call<ConsolidatedWeather> getTorontoWeatherData();

    @GET("9807")
    Call<ConsolidatedWeather> getVancouverWeatherData();

    @GET("12586539")
    Call<ConsolidatedWeather> getMumbaiWeatherData();

    @GET("2295405")
    Call<ConsolidatedWeather> getSuratWeatherData();
}
