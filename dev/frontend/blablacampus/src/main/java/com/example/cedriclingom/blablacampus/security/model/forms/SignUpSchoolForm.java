package com.example.cedriclingom.blablacampus.security.model.forms;

import com.example.cedriclingom.blablacampus.BR;
import com.example.cedriclingom.blablacampus.security.model.dto.SchoolDTO;
import com.google.android.libraries.places.api.model.Place;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class SignUpSchoolForm extends BaseObservable {

    private static final String TAG = "SignUpSchoolForm";

    private MutableLiveData<SchoolDTO> buttonClick;
    private MutableLiveData<Boolean> valid;
    private SchoolDTO school;


    public SignUpSchoolForm() {

        buttonClick= new MutableLiveData<>();
        valid = new MutableLiveData<>();
        school = new SchoolDTO();
    }

    @Bindable
    public boolean isValid() {
        notifyPropertyChanged(BR.valid);
        return school.getSchoolLocation() != null;
    }

    public void onClick() {

        boolean validated = isValid();
        this.valid.setValue(validated);

        if (validated) {
            buttonClick.setValue(school);
        }
    }

    @Bindable
    public Place getLocation() {
        return school.getSchoolLocation();
    }

    public void setLocation(Place place) {
        school.setSchoolLocation(place);
        notifyPropertyChanged(BR.location);
    }

    public MutableLiveData isValidated() {
        return valid;
    }

    public SchoolDTO getSchool() {
        return school;
    }
}
