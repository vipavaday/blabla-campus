package com.example.cedriclingom.blablacampus.main.utils;

import android.widget.TextView;

import com.example.cedriclingom.blablacampus.R;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RouteViewHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout layout;
    private TextView route;
    private TextView duration;
    private ConstraintLayout activeDays;

    public RouteViewHolder(ConstraintLayout v) {
        super(v);

        layout = v;
        route = v.findViewById(R.id.route_tx);
        duration = v.findViewById(R.id.duration_tx);
        activeDays = v.findViewById(R.id.active_days);
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

    public TextView getDuration() {
        return duration;
    }
}
