package com.example.cedriclingom.blablacampus.routes.service;

import android.content.Context;

import com.example.cedriclingom.blablacampus.routes.models.Route;
import com.example.cedriclingom.blablacampus.security.models.ConnectionModel;
import com.example.cedriclingom.blablacampus.security.models.User;
import com.example.cedriclingom.blablacampus.security.utils.MyHttpClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.entity.StringEntity;

public class RouteService extends MyHttpClientService {

    private static List<Route> routes;

    private static List<Route> userRoutes;









    public static List<Route> getRoutes() {
        return routes;
    }

    public static void setRoutes(List<Route> routes) {
        RouteService.routes = routes;
    }

    public static List<Route> getUserRoutes() {
        return userRoutes;
    }


    private static void updateUserRoutes(JSONArray response){

        userRoutes = new ArrayList<Route>();

        for(int i = 0; i < response.length(); ++i){

            Route route = new Route();

            try {

                route.initialiseRoute(response.getJSONObject(i));

                getUserRoutes().add(route);

            } catch (JSONException e) {

                e.printStackTrace();

            }

        }

    }

    public static void setUserRoutes(byte[] responseBody) {

        if(responseBody == null){

            userRoutes = null;

        }else{

            JSONArray response = null;

            try {

                    response = new JSONArray(new String(responseBody));

                    updateUserRoutes(response);

            } catch (JSONException e) {

                e.printStackTrace();

            }

        }

    }



    public static void doGetUserRoutes(String username, AsyncHttpResponseHandler asyncHttpResponseHandler){

        String relativeUrl = "/user/routes";

        RequestParams params = new RequestParams();

        params.put("username", username);

        get(relativeUrl, params ,asyncHttpResponseHandler);

    }


    public static void doSaveUserRoute(Route newRoute, Route modifiedRoute, Context context, AsyncHttpResponseHandler asyncHttpResponseHandler){

        String relativeUrl = "/user/routes";

        StringEntity jsonEntity = null;

        ObjectMapper mapper = new ObjectMapper();

        if(newRoute != null){

            //send a post request

            try {

                    jsonEntity = new StringEntity(mapper.writeValueAsString(newRoute), "UTF-8");

            } catch (JsonProcessingException e) {

                e.printStackTrace();

            }

        }else if(modifiedRoute != null) {

            //send a put request

            try {

                jsonEntity = new StringEntity(mapper.writeValueAsString(modifiedRoute), "UTF-8");

            } catch (JsonProcessingException e) {

                e.printStackTrace();

            }


        }

        postEntity(context, relativeUrl, jsonEntity ,asyncHttpResponseHandler);


    }

}
