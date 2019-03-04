package com.example.cedriclingom.blablacampus.fragments.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.main.model.RouteDTO;
import com.example.cedriclingom.blablacampus.main.services.RideRepository;
import com.example.cedriclingom.blablacampus.main.services.RouteRepository;
import com.example.cedriclingom.blablacampus.main.utils.RideListAdapter;
import com.example.cedriclingom.blablacampus.main.utils.RouteListAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RouteListFragment extends AuthFragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<RouteDTO> routes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = getView().findViewById(R.id.route_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        routes = new LinkedList<>();
        mAdapter = new RouteListAdapter(routes);
        recyclerView.setAdapter(mAdapter);

        RouteRepository.getUserRoutes("victor.pavaday@gmail.com").subscribe(routeList -> {

            routes.addAll(routeList);
            mAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public int getTitle() {
        return 0;
    }
}
