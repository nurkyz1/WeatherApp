package com.geektech.weatherapp.data.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.local.WeatherDao;
import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.data.models.Weather_1;
import com.geektech.weatherapp.data.remote.WeatherApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepositories {

    private String nameCiti;
    private WeatherApi api;
    private WeatherDao dao;


    public void setNameCiti(String nameCiti) {
        this.nameCiti = nameCiti;
    }

    @Inject
    public MainRepositories(WeatherApi api,WeatherDao dao) {
        this.api = api;
        this.dao = dao;
    }

    public MutableLiveData<Resource<Weather>> getTemp() {
        MutableLiveData<Resource<Weather>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        api.getWeatherByCity(nameCiti,"9b5fe619bf9ed90cb08d1acc1737340c", "metric").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful() && response.body() !=null){
                liveData.postValue(Resource.success(response.body()));
                dao.insert(response.body());
                    Log.e("TAG", "onResponse:" );
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                liveData.postValue(Resource.error(t.getLocalizedMessage(),null));
            }
        });


    return liveData;
    }


    }
