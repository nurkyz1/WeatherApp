package com.geektech.weatherapp.data.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private  OkHttpClient provideOkHttpClient(){
        return  new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(provideLoginInterceptor())
                .build();
    }
    private Interceptor provideLoginInterceptor() {
        return  new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).client(provideOkHttpClient())
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .build();

    public  WeatherApi provideApi(){
        return  retrofit.create(WeatherApi.class);
    }

}
