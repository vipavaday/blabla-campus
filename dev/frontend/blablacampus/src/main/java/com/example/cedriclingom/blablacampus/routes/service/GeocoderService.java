package com.example.cedriclingom.blablacampus.routes.service;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;

import com.example.cedriclingom.blablacampus.security.utils.MyHttpClientService;

public class GeocoderService extends MyHttpClientService {

    private static Geocoder geocoder;



    public static Geocoder getGeocoder(Context context){

        if(geocoder == null){

            geocoder = new Geocoder(context);
        }

        return geocoder;
    }





}
