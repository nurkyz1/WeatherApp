package com.geektech.weatherapp.data.remote;

import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.data.models.Weather_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather")
    Call<Weather> getWeatherByCity(
      @Query("q") String cityName ,
      @Query("appid") String appId,
      @Query("units") String metric
    );


}
