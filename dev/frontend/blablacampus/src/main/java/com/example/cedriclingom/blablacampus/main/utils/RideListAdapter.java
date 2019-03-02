package com.example.cedriclingom.blablacampus.main.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.main.model.RideDTO;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RideListAdapter extends RecyclerView.Adapter {

    private List<RideDTO> rides;

    public RideListAdapter(List<RideDTO> rides) {
        this.rides = rides;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_ride, parent, false);

        RideViewHolder vh = new RideViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RideViewHolder rvh = (RideViewHolder)holder;
        RideDTO currRide = rides.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
        String date = sdf.format(currRide.getDate());

        rvh.getRoute().setText(currRide.getStartingPoint()+" - "+currRide.getEndPoint());
        rvh.getDate().setText(date);
        rvh.getAvailableSeats().setText(String.valueOf(currRide.getNbSeats()));
        rvh.getDriver().setText(currRide.getDriver());
        rvh.getDuration().setText(String.valueOf(currRide.getDuration()));
    }

    @Override
    public int getItemCount() {
        return rides.size();
    }
}
