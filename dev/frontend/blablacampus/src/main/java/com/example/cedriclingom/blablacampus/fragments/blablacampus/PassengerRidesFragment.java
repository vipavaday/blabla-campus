package com.example.cedriclingom.blablacampus.fragments.blablacampus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PassengerRidesFragment extends AuthFragment {

    public PassengerRidesFragment() {
        super();
        setAuth(false);
        setAccessDeniedHandler(AccessDeniedHandlerFactory.getHandler(RidesFragment.ACCESS_DENIED_HANDLER));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View passengerRidesView = inflater.inflate(R.layout.fragment_rides_passenger, container, false);

        return passengerRidesView;
    }

    @Override
    public int getTitle() {

        return R.string.tab_item_passager;
    }
}