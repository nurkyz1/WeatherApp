package com.geektech.weatherapp.data.local.convertor;

import androidx.room.TypeConverter;

import com.geektech.weatherapp.data.models.Main;
import com.geektech.weatherapp.data.models.Weather_1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Weather1Convertor {

    @TypeConverter
    public String fromMainString(List<Weather_1> weather_1){
        if (weather_1 ==null ){
            return  null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather_1>>(){}.getType();
        return gson.toJson(weather_1,type);
    }

    @TypeConverter
    public List<Weather_1> fromMainSting(String weatherString){
        if (weatherString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather_1>>(){}.getType();
        return  gson.fromJson(weatherString,type);
    }
}
