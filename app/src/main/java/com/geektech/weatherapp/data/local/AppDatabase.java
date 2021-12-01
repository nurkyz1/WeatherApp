package com.geektech.weatherapp.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.geektech.weatherapp.data.local.convertor.MainConvertor;
import com.geektech.weatherapp.data.models.Weather;

@Database(entities = {Weather.class}, version = 1)
@TypeConverters({MainConvertor.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract  WeatherDao weatherDao();

}
