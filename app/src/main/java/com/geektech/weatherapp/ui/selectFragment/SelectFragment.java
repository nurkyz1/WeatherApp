package com.geektech.weatherapp.ui.selectFragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.weatherapp.R;
import com.geektech.weatherapp.base.BaseFragment;
import com.geektech.weatherapp.databinding.FragmentSelectBinding;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SelectFragment extends BaseFragment<FragmentSelectBinding> {

    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host);
        navController = navHostFragment.getNavController();
    }

    @Override
    protected FragmentSelectBinding bind() {
        return FragmentSelectBinding.inflate(getLayoutInflater());
    }


    @Override
    protected void setupUI() {
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.requireNonNull(binding.editTown.getText()).toString().isEmpty()){
                    Toast.makeText(requireContext(), "Введите название города", Toast.LENGTH_SHORT).show();
                }else{
                    navController.navigate((NavDirections) SelectFragmentDirections
                    .actionSelectFragmentToWeatherFragment(binding.editTown.getText().toString()));
                }
            }
        });

    }

    @Override
    protected void setupObservers() {

    }
}