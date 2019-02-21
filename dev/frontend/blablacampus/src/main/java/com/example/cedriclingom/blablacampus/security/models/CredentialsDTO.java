package com.example.cedriclingom.blablacampus.security.models;

public class CredentialsDTO {

    private String email;
    private String password;




    public CredentialsDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public CredentialsDTO() {
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
