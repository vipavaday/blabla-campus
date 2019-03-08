package com.example.cedriclingom.blablacampus.routes.models;

import com.example.cedriclingom.blablacampus.security.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Ride {


    private int id;

    private Date date;

    private boolean active;

    private Route route;

    private User driver;

    private int availableSeats;




    public Ride() {

    }

    public Ride(Date date, boolean active, Route route, User driver, int availableSeats) {
        this.date = date;
        this.active = active;
        this.route = route;
        this.driver = driver;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", date=" + date +
                ", active=" + active +
                ", route=" + route +
                ", driver=" + driver +
                ", availableSeats=" + availableSeats +
                '}';
    }



    public void initialiseRide(JSONObject ride){

        if(ride != null){

            try {

                setId(ride.getInt("id"));

                setDate(new Date(ride.getLong("date")));

                setActive(ride.getBoolean("active"));

                setDriver(new User());

                getDriver().initialiseUser(ride.getJSONObject("driver"));

                setAvailableSeats(ride.getInt("availableSeats"));

                setRoute(null);

            } catch (JSONException e) {

                e.printStackTrace();

            }




        }
    }
}
