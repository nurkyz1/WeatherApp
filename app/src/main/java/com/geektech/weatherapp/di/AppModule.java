package com.geektech.weatherapp.di;

import android.content.Context;

import com.geektech.weatherapp.data.local.AppDatabase;
import com.geektech.weatherapp.data.local.RoomClient;
import com.geektech.weatherapp.data.local.WeatherDao;
import com.geektech.weatherapp.data.remote.RetrofitClient;
import com.geektech.weatherapp.data.remote.WeatherApi;
import com.geektech.weatherapp.data.repositories.MainRepositories;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn({SingletonComponent.class})
public abstract class AppModule {

    @Provides
    public static WeatherApi provideApi(){
        return new RetrofitClient().provideApi();
    }
    @Provides
    public static MainRepositories provideMain(WeatherApi api, WeatherDao dao){
        return new MainRepositories(api,dao);
    }
    @Provides
    public static AppDatabase provideDatabase(@ApplicationContext Context context){
        return new RoomClient().provideDatabase(context);
    }
    @Provides
    public static WeatherDao provideWeatherDao(AppDatabase database){
        return database.weatherDao();
    }
}
