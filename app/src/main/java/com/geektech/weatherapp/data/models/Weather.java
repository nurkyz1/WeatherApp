package com.geektech.weatherapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.geektech.weatherapp.data.local.convertor.CloudConvertor;
import com.geektech.weatherapp.data.local.convertor.MainConvertor;
import com.geektech.weatherapp.data.local.convertor.SysConvertor;
import com.geektech.weatherapp.data.local.convertor.Weather1Convertor;
import com.geektech.weatherapp.data.local.convertor.WindConvertor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity
public class Weather {

//    @SerializedName("coord")
//    @Expose
//    private Coord coord;
    @SerializedName("weather")
    @Expose
    @TypeConverters({Weather1Convertor.class})
    private List<Weather_1> weather1;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    @TypeConverters({MainConvertor.class})
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    @TypeConverters({WindConvertor.class})
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    @TypeConverters({CloudConvertor.class})
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    @TypeConverters({SysConvertor.class})
    private Sys sys;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

//    public Coord getCoord() {
//        return coord;
//    }
//
//    public void setCoord(Coord coord) {
//        this.coord = coord;
//    }


    public List<Weather_1> getWeather1() {
        return weather1;
    }

    public void setWeather1(List<Weather_1> weather1) {
        this.weather1 = weather1;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
