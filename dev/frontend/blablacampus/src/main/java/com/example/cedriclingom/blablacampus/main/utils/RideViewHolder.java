package com.example.cedriclingom.blablacampus.main.utils;

import android.widget.TextView;

import com.example.cedriclingom.blablacampus.R;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RideViewHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout layout;
    private TextView route;
    private TextView availableSeats;
    private TextView date;
    private TextView driver;
    private TextView duration;

    public RideViewHolder(ConstraintLayout v) {
        super(v);
        layout = v;

        route = v.findViewById(R.id.route_tx);
        availableSeats = v.findViewById(R.id.available_seats_tx);
        date = v.findViewById(R.id.date_tx);
        driver = v.findViewById(R.id.driver_tx);
        duration = v.findViewById(R.id.duration_tx);
    }

    public ConstraintLayout getLayout() {
        return layout;
    }

    public void setLayout(ConstraintLayout layout) {
        this.layout = layout;
    }

    public TextView getRoute() {
        return route;
    }

    public TextView getAvailableSeats() {
        return availableSeats;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getDriver() {
        return driver;
    }

    public TextView getDuration() {
        return duration;
    }
}
