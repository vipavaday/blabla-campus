package com.example.cedriclingom.blablacampus.security.models;

public class ConnectionModel {

    private String email;
    private String password;




    public ConnectionModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public ConnectionModel() {
        this(null, null);
    }





    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }





    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
