package com.example.cedriclingom.blablacampus.security.model.dto;

import com.example.cedriclingom.blablacampus.security.model.forms.FormInput;
import com.example.cedriclingom.blablacampus.security.model.forms.StringFormInput;

public class UserDTO {

    private FormInput<String> firstname;
    private FormInput<String> lastname;
    private FormInput<String> phone;

    public UserDTO(){
        firstname = new StringFormInput(true);
        lastname = new StringFormInput(true);
        phone = new StringFormInput(true);
    }


    public FormInput<String> getFirstname() {
        return firstname;
    }

    public void setFirstname(FormInput<String> firstname) {
        this.firstname = firstname;
    }

    public FormInput<String> getLastname() {
        return lastname;
    }

    public void setLastname(FormInput<String> lastname) {
        this.lastname = lastname;
    }

    public FormInput<String> getPhone() {
        return phone;
    }

    public void setPhone(FormInput<String> phone) {
        this.phone=phone;
    }
}
