package com.geektech.weatherapp.ui.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.data.models.Weather_1;
import com.geektech.weatherapp.data.repositories.MainRepositories;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    private String city;
    private MainRepositories repositories;
    public LiveData<Resource<Weather>> tempLiveData;

    public void setCity(String city) {
        this.city = city;
    }


    @Inject
    public WeatherViewModel(MainRepositories repositories) {
        this.repositories = repositories;
    }


    public void fetchTemp() {
        repositories.setNameCiti(city);
        tempLiveData=repositories.getTemp();
    }

}
