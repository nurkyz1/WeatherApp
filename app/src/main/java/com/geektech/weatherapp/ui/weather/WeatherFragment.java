package com.geektech.weatherapp.ui.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.geektech.weatherapp.R;
import com.geektech.weatherapp.base.BaseFragment;
import com.geektech.weatherapp.data.local.WeatherDao;
import com.geektech.weatherapp.data.models.Main;
import com.geektech.weatherapp.data.models.Sys;
import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.data.models.Weather_1;
import com.geektech.weatherapp.data.models.Wind;
import com.geektech.weatherapp.databinding.FragmentWeatherBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherFragment extends BaseFragment<FragmentWeatherBinding> {

    private NavController navController;
    private WeatherViewModel model;
    private Wind wind;
    private Main main;
     private WeatherFragmentArgs args;
     private Weather weather;
     private Sys sys;
     private ArrayList<Weather_1> weather_1s = new ArrayList<>();
     @Inject
    WeatherDao dao;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavHostFragment navHostFragment = (NavHostFragment)
                requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        if (getArguments() !=null)
            args =WeatherFragmentArgs.fromBundle(getArguments());
    }

    @Override
    protected FragmentWeatherBinding bind() {
        return  FragmentWeatherBinding.inflate(getLayoutInflater());

    }

    @Override
    protected void setupUI() {
        binding.textTown.setOnClickListener(v -> navController.navigate(R.id.action_weatherFragment_to_selectFragment));
        model = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
        model.setCity(args.getWeatherId());
        model.fetchTemp();
    }

    @Override
    protected void setupObservers() {
        model.tempLiveData.observe(getViewLifecycleOwner(), response -> {
     switch (response.status){
         case SUCCESS:
             wind = response.data.getWind();
             weather = response.data;
             main = response.data.getMain();
             sys = response.data.getSys();
             weather_1s = (ArrayList<Weather_1>) response.data.getWeather1();
             binding.progress.setVisibility(View.GONE);
             setWeather();
             break;

         case LOADING:
             binding.progress.setVisibility(View.VISIBLE);
             break;
         case ERROR:
             Toast.makeText(requireActivity(), "Internet not connected! Loading last data", Toast.LENGTH_SHORT).show();
             binding.progress.setVisibility(View.GONE);
             wind = dao.getWeather().getWind();
             main = dao.getWeather().getMain();
             sys = dao.getWeather().getSys();
             weather = dao.getWeather();
             weather_1s = (ArrayList<Weather_1>) dao.getWeather().getWeather1();
             setWeather();
             break;
     }
        });

    }

    @SuppressLint("SetTextI18n")
    private void setWeather() {
        binding.textSunny.setText(weather_1s.get(0).getMain());
        Glide.with(requireContext()).load("https://openweathermap.org/img/wn/"+weather_1s.get(0).getIcon()+".png")
                .override(100,100)
                .into(binding.imgSunny);
        binding.textTemp.setText(String.valueOf((int) Math.round(main.getTempMax()) ));
        binding.textWind.setText((int) Math.round(wind.getSpeed())+" m/s ");
        binding.textTown.setText(weather.getName());
        binding.textTemperature.setText(String.valueOf((int) Math.round(main.getTemp())));
        binding.textPressure.setText(main.getPressure()+"mBar");
        binding.textHumidity.setText(main.getHumidity()+" %");
        binding.textTempC.setText(String.valueOf((int) Math.round(main.getTempMin())));
    }
}