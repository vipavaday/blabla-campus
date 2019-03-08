package com.example.cedriclingom.blablacampus.routes.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Address {



    private int id;

    private double longitude;

    private double latitude;

    private String Address;



    public Address() {

    }


    public Address(double longitude, double latitude, String Address) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
        this.Address = Address;
    }





    public int getId() {
        return id;
    }



    public double getLongitude() {
        return longitude;
    }



    public double getLatitude() {
        return latitude;
    }



    public String getAddress() {
        return Address;
    }



    public void setId(int id) {
        this.id = id;
    }



    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



    public void setLineAddress(String Address) {
        this.Address = Address;
    }





    public void initialiseAddress(JSONObject address){

        if(address != null){

            try {

                setId(address.getInt("id"));

                setLatitude(address.getDouble("latitude"));

                setLongitude(address.getDouble("longitude"));

                setLineAddress(address.getString("address"));

            } catch (JSONException e) {

                e.printStackTrace();

            }
        }
    }
}
