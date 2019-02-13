package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DriverRidesFragment extends AuthFragment {

    private static DriverRidesFragment fragment;


    public DriverRidesFragment() {

        setAuth(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View driverRidesView = inflater.inflate(R.layout.fragment_driver_rides, container, false);

        return driverRidesView;
    }
}
