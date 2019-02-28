package com.example.cedriclingom.blablacampus.security.model.dto;

import com.example.cedriclingom.blablacampus.security.model.forms.FormInput;
import com.example.cedriclingom.blablacampus.security.model.forms.StringFormInput;

public class CredentialsDTO {

    private FormInput<String> email;
    private FormInput<String> password;
    private FormInput<String> passwordConfirm;


    public CredentialsDTO(String email, String password) {

        this.email = new StringFormInput(true);
        this.password = new StringFormInput(true);
        this.passwordConfirm = new StringFormInput(true);

        this.email.setValue(email);
        this.password.setValue(password);
    }

    public CredentialsDTO() {
        this("", "");
    }


    public FormInput<String> getEmail() {
        return email;
    }

    public void setEmail(FormInput<String> email) {
        this.email = email;
    }

    public FormInput<String> getPassword() {
        return password;
    }

    public void setPassword(FormInput<String> password) {
        this.password = password;
    }

    public FormInput<String> getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(FormInput<String> passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
