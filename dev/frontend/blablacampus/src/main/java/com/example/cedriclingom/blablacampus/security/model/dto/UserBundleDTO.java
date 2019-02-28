package com.example.cedriclingom.blablacampus.security.model.dto;

import com.example.cedriclingom.blablacampus.security.model.dto.jsonAdapters.UserBundleAdapter;
import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(UserBundleAdapter.class)
public class UserBundleDTO {

    private transient UserDTO user;
    private transient CredentialsDTO credentials;
    private transient SchoolDTO school;
    private transient long lastUpdate = 0;

    public UserBundleDTO(UserDTO user, CredentialsDTO credentials, SchoolDTO school) {

        this.user = user;
        this.credentials = credentials;
        this.school = school;
    }

    public UserBundleDTO() {
        this(new UserDTO(), new CredentialsDTO(), new SchoolDTO());
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFirstname() {
        return user.getFirstname().getValue();
    }

    public void setFirstname(String firstname) {
        user.getFirstname().setValue(firstname);
    }

    public String getLastname() {
        return user.getLastname().getValue();
    }

    public void setLastname(String lastname) {
        user.getLastname().setValue(lastname);
    }

    public String getPhone() {
        return user.getPhone().getValue();
    }

    public void setPhone(String phone) {
        user.getPhone().setValue(phone);
    }

    public String getEmail() {
        return credentials.getEmail().getValue();
    }

    public void setEmail(String email) {
        credentials.getEmail().setValue(email);
    }

    public String getPassword() {
        return credentials.getPassword().getValue();
    }

    public void setPassword(String password) {
        credentials.getPassword().setValue(password);
    }
}
