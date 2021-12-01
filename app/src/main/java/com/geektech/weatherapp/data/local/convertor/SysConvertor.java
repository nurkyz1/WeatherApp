package com.geektech.weatherapp.data.local.convertor;

import androidx.room.TypeConverter;

import com.geektech.weatherapp.data.models.Main;
import com.geektech.weatherapp.data.models.Sys;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class SysConvertor {

    @TypeConverter
    public String fromMainString(Sys sys){
        if (sys ==null ){
            return  null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Sys>(){}.getType();
        return gson.toJson(sys,type);
    }

    @TypeConverter
    public Sys fromMainSting(String sysString){
        if (sysString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Sys>(){}.getType();
        return  gson.fromJson(sysString,type);
    }
}
