package com.example.cedriclingom.blablacampus.main.services;

import com.example.cedriclingom.blablacampus.main.model.RideDTO;
import com.example.cedriclingom.blablacampus.security.model.dto.CredentialsDTO;
import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;
import com.example.cedriclingom.blablacampus.security.services.UserService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RideRepository {

    private static UserService userService;

    static {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://51.77.158.156:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userService = retrofit.create(UserService.class);
    }

    public static Observable<List<RideDTO>> getRidesForRoute(String startingPoint, String endPoint) {

        return Observable.create(emitter -> {

            List<RideDTO> rides = new LinkedList<>();
            rides.add(new RideDTO("Cézeaux","Riom", 3, 30, new Date(), "Cédric"));
            rides.add(new RideDTO("Rotonde","Royat", 1, 15, new Date(), "Richard"));
            rides.add(new RideDTO("Nohanent","Fac de lettre", 4, 40, new Date(), "Paul"));
            rides.add(new RideDTO("Durtol","Fac dentaire", 2, 20, new Date(), "Pierre"));

            emitter.onNext(rides);
        });
    }
}
