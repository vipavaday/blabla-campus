package com.example.cedriclingom.blablacampus.security.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {


    private Integer userId;

    private String firstname;

    private String lastname;

    private String email;

    private String phone;

    private String picPath;

    private boolean active;

    private String username;

    private String authorities;

    private boolean accountNonExpired;

    private boolean nonlocked;

    private boolean credentialsNonExpired;














    public User() {

    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {

        this.email = email;
    }





    public boolean isAccountNonExpired() {

        return false;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {

        return nonlocked;
    }

    public void setAccountNonLocked(boolean nonlocked) {

        this.nonlocked = nonlocked  ;
    }

    public boolean isCredentialsNonExpired() {

        return false;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {

        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {

        return active;
    }

    public void setEnabled(boolean enabled) {

        this.active = enabled;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }



    public void initialiseUser(JSONObject user){

        if(user != null){

            try {

                setUserId(user.getInt("userId"));

                setFirstname(user.getString("firstname"));

                setLastname(user.getString("lastname"));

                setEmail(user.getString("email"));

                setPhone(user.getString("phone"));

                setPicPath(user.getString("picPath"));

                setEnabled(user.getBoolean("enabled"));

                setUsername(user.getString("username"));

                setAuthorities(user.getString("authorities"));

                setAccountNonExpired(user.getBoolean("accountNonExpired"));

                setAccountNonLocked(user.getBoolean("accountNonLocked"));

                setCredentialsNonExpired(user.getBoolean("credentialsNonExpired"));

            } catch (JSONException e) {

                e.printStackTrace();

            }

        }

    }


}
