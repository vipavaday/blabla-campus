package com.example.cedriclingom.blablacampus.security.model.dto;

import com.google.android.libraries.places.api.model.Place;

public class SchoolDTO{

    private Place schoolLocation;

    public Place getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(Place schoolLocation) {
        this.schoolLocation = schoolLocation;
    }
}
