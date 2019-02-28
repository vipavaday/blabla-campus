package com.example.cedriclingom.blablacampus.security.model.dto;

import com.google.android.libraries.places.api.model.Place;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class SchoolDTO{

    private Place schoolLocation;

    public Place getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(Place schoolLocation) {
        this.schoolLocation = schoolLocation;
    }
}
