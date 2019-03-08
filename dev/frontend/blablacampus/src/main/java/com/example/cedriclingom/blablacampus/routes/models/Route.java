package com.example.cedriclingom.blablacampus.routes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Route {

    @JsonProperty("id")
    private int id;

    @JsonProperty("startingPoint")
    private Place startingPoint;

    @JsonProperty("endPoint")
    private Place endPoint;

    @JsonProperty("rides")
    private List<Ride> rides;


    public Route() {

    }

    public Route(Place startingPoint, Place endPoint, List<Ride> rides) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.rides = rides;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Place getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Place startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Place getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Place endPoint) {
        this.endPoint = endPoint;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }


    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startingPoint=" + startingPoint +
                ", endPoint=" + endPoint +
                ", rides=" + rides +
                '}';
    }


    public void initialiseRoute(JSONObject route){

        if(route != null){

            try {

                setId(route.getInt("id"));

                setStartingPoint(new Place());

                getStartingPoint().initialisePlace(route.getJSONObject("startingPoint"));

                setEndPoint(new Place());

                getEndPoint().initialisePlace(route.getJSONObject("endPoint"));

                JSONArray jsonrides = route.getJSONArray("rides");

                if(jsonrides != null){

                    rides = new ArrayList<Ride>();

                    for(int i = 0; i < jsonrides.length(); ++i){

                        Ride ride = new Ride();

                        ride.initialiseRide(jsonrides.getJSONObject(i));

                        rides.add(ride);
                    }
                }

            } catch (JSONException e) {

                e.printStackTrace();

            }
        }

    }
}
