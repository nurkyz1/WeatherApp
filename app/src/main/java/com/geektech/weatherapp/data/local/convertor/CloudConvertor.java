package com.geektech.weatherapp.data.local.convertor;

import androidx.room.TypeConverter;

import com.geektech.weatherapp.data.models.Clouds;
import com.geektech.weatherapp.data.models.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class CloudConvertor {

    @TypeConverter
    public String fromMainString(Clouds clouds){
        if (clouds ==null ){
            return  null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Clouds>(){}.getType();
        return gson.toJson(clouds,type);
    }

    @TypeConverter
    public Clouds fromMainSting(String cloudString){
        if (cloudString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Clouds>(){}.getType();
        return  gson.fromJson(cloudString,type);
    }
}
