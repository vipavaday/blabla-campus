package com.example.cedriclingom.blablacampus.fragments.blablacampus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

public class DriverRidesFragment extends AuthFragment {

    private static DriverRidesFragment fragment;


    public DriverRidesFragment() {
        super();
        setAuth(true);
        setAccessDeniedHandler(AccessDeniedHandlerFactory.getHandler(RidesFragment.ACCESS_DENIED_HANDLER));
    }

    @Override
    public void onStart(){

        super.onStart();

        /*FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();*/

        if(ConnectionService.isConnected()){


            System.out.println("I can get the routes!");

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View driverRidesView = inflater.inflate(R.layout.fragment_rides_driver, container, false);

        return driverRidesView;
    }

    @Override
    public int getTitle() {

        return R.string.tab_item_driver;
    }
}
