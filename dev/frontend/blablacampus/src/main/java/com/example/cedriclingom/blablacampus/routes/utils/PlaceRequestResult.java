package com.example.cedriclingom.blablacampus.routes.utils;

public class PlaceRequestResult {

    private String placeName;
    private String placeDescription;
    private boolean studyingPlace;


    public PlaceRequestResult(String placeName, String placeDescription) {

        this.placeName = placeName;

        this.placeDescription = placeDescription;

    }

    public PlaceRequestResult() {

        this(null, null);

        this.studyingPlace = false;

    }




    public String getPlaceName() {

        return placeName;

    }

    public String getPlaceDescription() {

        return placeDescription;

    }

    public boolean isStudyingPlace() {
        return studyingPlace;
    }



    public void setPlaceName(String placeName) {

        this.placeName = placeName;

    }

    public void setPlaceDescription(String placeDescription) {

        this.placeDescription = placeDescription;

    }

    public void setStudyingPlace(boolean studyingPlace) {
        this.studyingPlace = studyingPlace;
    }


    @Override
    public String toString() {
        return "PlaceRequestResult{" +
                "placeName='" + placeName + '\'' +
                ", placeDescription='" + placeDescription + '\'' +
                ", studyingPlace=" + studyingPlace +
                '}';
    }
}
