package com.example.cedriclingom.blablacampus.main.model;

import java.util.Date;

public class RouteDTO {

    private String startingPoint;
    private String endPoint;
    private int duration;
    private Boolean[] activeDays;

    public RouteDTO(String startingPoint, String endPoint, int duration) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.activeDays = new Boolean[7];
    }

    public RouteDTO() {
        this("","",0);
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void clearActiveDays(){

        for(int i =0; i< activeDays.length; ++i){
            activeDays[i] = false;
        }
    }

    public void setActiveDay(int day, boolean active){
        activeDays[day] = active;
    }

}
