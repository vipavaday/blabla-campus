package com.example.cedriclingom.blablacampus.security.service;

import com.example.cedriclingom.blablacampus.security.models.User;
import com.example.cedriclingom.blablacampus.security.utils.MyHttpClientService;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

public class UserService extends MyHttpClientService {

    private static User userInfos = null;






    public static User getUserInfos(){

        return userInfos;
    }











    public static void getUserInformations(String username, AsyncHttpResponseHandler asyncHttpResponseHandler){

        String relativeUrl = "/user/infos";

        RequestParams params = new RequestParams();
        params.put("username", username);

        get(relativeUrl, params, asyncHttpResponseHandler);

    }












    public static void setUserInfos (byte[] responseBody) throws JSONException {



        JSONObject response = null;

        try {

            if(responseBody != null){

                response = new JSONObject(new String(responseBody));

                userInfos = new User();
            }


        } catch (JSONException e) {

            e.printStackTrace();

        }


        if(userInfos != null){

            userInfos.setUserId(Integer.valueOf(response.getString("userId")));

            userInfos.setFirstname(response.getString("firstname"));

            userInfos.setLastname(response.getString("lastname"));

            userInfos.setEmail(response.getString("email"));

            userInfos.setPhone(response.getString("phone"));

            userInfos.setPicPath(response.getString("picPath"));

            userInfos.setEnabled(Boolean.valueOf(response.getString("enabled")));

            userInfos.setUsername(response.getString("username"));

            userInfos.setAuthorities(response.getString("authorities"));

            userInfos.setAccountNonLocked(Boolean.valueOf(response.getString("accountNonExpired")));

            userInfos.setAccountNonLocked(Boolean.valueOf(response.getString("accountNonLocked")));

            userInfos.setCredentialsNonExpired(Boolean.valueOf(response.getString("credentialsNonExpired")));

        }

    }







}
