package com.example.cedriclingom.blablacampus.main.model;

import java.util.Date;

public class RideDTO {

    private String startingPoint;
    private String endPoint;
    private int nbSeats;
    private int duration;
    private Date date;
    private String driver;

    public RideDTO(String startingPoint, String endPoint, int nbSeats, int duration, Date date, String driver) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.nbSeats = nbSeats;
        this.duration = duration;
        this.date = date;
        this.driver = driver;
    }

    public RideDTO() {
        this("","",0, 0, new Date(), "");
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
