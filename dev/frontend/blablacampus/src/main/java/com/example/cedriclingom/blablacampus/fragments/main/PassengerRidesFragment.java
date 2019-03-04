package com.example.cedriclingom.blablacampus.fragments.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PassengerRidesFragment extends AuthFragment {

    private ImageButton toggleSearchBtn;
    private ConstraintLayout ridesSearchLayout;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toggleSearchBtn =  getView().findViewById(R.id.search_toggle_btn);
        ridesSearchLayout = getView().findViewById(R.id.passenger_rides_search_collapse);
        toggleSearchBtn.setOnClickListener(this::getRidesSearchToggleListener);

        RideFormFragment rideForm = (RideFormFragment) getChildFragmentManager().findFragmentById(R.id.passenger_rides_search_collapse);
        rideForm.initSubmitBtn(R.string.ride_search_btn, (v)-> {
            Toast.makeText( getContext(),"Recherche lancée", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getTitle() {

        return R.string.tab_item_passager;
    }

    private void getRidesSearchToggleListener(View v){

        int visibility = (ridesSearchLayout.getVisibility()== View.VISIBLE)?View.GONE:View.VISIBLE;
        ridesSearchLayout.setVisibility(visibility);
    }
}
