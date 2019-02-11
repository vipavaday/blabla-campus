package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PassengerRidesFragment extends Fragment {
    

    private static PassengerRidesFragment fragment;



    public static PassengerRidesFragment newInstance() {

        if(PassengerRidesFragment.fragment == null){

            PassengerRidesFragment.fragment = new PassengerRidesFragment();
        }

        return PassengerRidesFragment.fragment;
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View passengerRidesView = inflater.inflate(R.layout.fragment_passenger_rides, container, false);


        return passengerRidesView;
    }
}
