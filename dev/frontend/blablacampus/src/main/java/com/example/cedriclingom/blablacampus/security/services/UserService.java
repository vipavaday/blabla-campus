package com.example.cedriclingom.blablacampus.security.services;

import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("user/register")
    Call<UserBundleDTO> createUser(@Body UserBundleDTO user);

    @GET("user/infos")
    Call<UserBundleDTO> getUser(@Query("username") String email);
}
