package com.example.cedriclingom.blablacampus.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.activities.RegistrationActivity;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DriverRidesFragment extends Fragment {

    private static DriverRidesFragment fragment;







    private  void showConnectionCard() {

        Intent intent =  new Intent(getActivity(), RegistrationActivity.class);

        startActivityForResult(intent, 0);

    }


    public void testUserConnection(){

        if(!ConnectionService.isConnected()){

            showConnectionCard();

            ConnectionService.doUserConnection();

        }
    }





    public static DriverRidesFragment newInstance() {

        if(DriverRidesFragment.fragment == null){

            DriverRidesFragment.fragment = new DriverRidesFragment();
        }

        return DriverRidesFragment.fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View driverRidesView = inflater.inflate(R.layout.fragment_driver_rides, container, false);

        return driverRidesView;
    }




}
