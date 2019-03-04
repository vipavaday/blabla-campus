package com.example.cedriclingom.blablacampus.main.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.main.model.RideDTO;
import com.example.cedriclingom.blablacampus.main.model.RouteDTO;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RouteListAdapter extends RecyclerView.Adapter {

    private List<RouteDTO> routes;

    public RouteListAdapter(List<RouteDTO> route) {
        this.routes = route;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_route, parent, false);

        RouteViewHolder vh = new RouteViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RouteViewHolder rvh = (RouteViewHolder)holder;
        RouteDTO currRoute = routes.get(position);
        rvh.getRoute().setText(currRoute.getStartingPoint()+" - "+currRoute.getEndPoint());
        rvh.getDuration().setText(String.valueOf(currRoute.getDuration()));

    }

    @Override
    public int getItemCount() {
        return routes.size();
    }
}
