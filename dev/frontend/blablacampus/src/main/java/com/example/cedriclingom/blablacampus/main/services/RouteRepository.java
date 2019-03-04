package com.example.cedriclingom.blablacampus.main.services;

import com.example.cedriclingom.blablacampus.main.model.RideDTO;
import com.example.cedriclingom.blablacampus.main.model.RouteDTO;
import com.example.cedriclingom.blablacampus.security.services.UserService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RouteRepository {

    private static UserService userService;

    static {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://51.77.158.156:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userService = retrofit.create(UserService.class);
    }

    public static Observable<List<RouteDTO>> getUserRoutes(String userEmail) {

        return Observable.create(emitter -> {

            List<RouteDTO> route = new LinkedList<>();
            route.add(new RouteDTO("Cézeaux","Riom", 25));
            route.add(new RouteDTO("Nohanent","Fac dentaire", 15));
            route.add(new RouteDTO("Rotonde","Chamallières", 25));
            route.add(new RouteDTO("Royat","Isima", 25));
            route.add(new RouteDTO("Cézeaux","Ceyrat", 25));

            emitter.onNext(route);
        });
    }
}
