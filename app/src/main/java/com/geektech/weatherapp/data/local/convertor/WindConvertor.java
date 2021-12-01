package com.geektech.weatherapp.data.local.convertor;

import androidx.room.TypeConverter;

import com.geektech.weatherapp.data.models.Main;
import com.geektech.weatherapp.data.models.Wind;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class WindConvertor {

    @TypeConverter
    public String fromMainString(Wind wind){
        if (wind ==null ){
            return  null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Wind>(){}.getType();
        return gson.toJson(wind,type);
    }

    @TypeConverter
    public Wind fromMainSting(String windString){
        if (windString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Wind>(){}.getType();
        return  gson.fromJson(windString,type);
    }
}
