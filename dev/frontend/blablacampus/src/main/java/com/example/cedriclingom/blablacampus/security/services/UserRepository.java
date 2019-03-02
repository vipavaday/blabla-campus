package com.example.cedriclingom.blablacampus.security.services;

import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private static UserService blablacampusService;

    static {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://51.77.158.156:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        blablacampusService = retrofit.create(UserService.class);
    }

    public static void saveUser(UserBundleDTO user, Callback<UserBundleDTO> onResponse) {

        blablacampusService.createUser(user).enqueue(onResponse);
    }
}
