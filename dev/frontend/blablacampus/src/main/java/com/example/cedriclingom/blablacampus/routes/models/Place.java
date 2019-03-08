package com.example.cedriclingom.blablacampus.routes.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Place {


    private int placeId;

    private String name;

    private String description;

    private boolean studyingPlace;

    private Address address;


    public Place() {

    }


    public Place(String name, String description, boolean studyingPlace, Address address) {
        this.name = name;
        this.description = description;
        this.studyingPlace = studyingPlace;
        this.address = address;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStudyingPlace() {
        return studyingPlace;
    }

    public void setStudyingPlace(boolean studyingPlace) {
        this.studyingPlace = studyingPlace;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", studyingPlace=" + studyingPlace +
                ", address=" + address +
                '}';
    }



    public void initialisePlace(JSONObject place){

        if(place != null){

            try {

                setPlaceId(place.getInt("placeId"));

                setName(place.getString("name"));

                setDescription(place.getString("description"));

                setStudyingPlace(place.getBoolean("studyingPlace"));

                setAddress(new Address());

                getAddress().initialiseAddress(place.getJSONObject("address"));


            } catch (JSONException e) {

                e.printStackTrace();

            }

        }

    }
}
