package com.example.cedriclingom.blablacampus.security.model.forms;

import com.example.cedriclingom.blablacampus.BR;
import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.model.dto.CredentialsDTO;

import java.util.regex.Pattern;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class SignUpCredentialsForm extends BaseObservable {

    private CredentialsDTO credentials;
    private MutableLiveData<CredentialsDTO> buttonClick;
    private MutableLiveData<Boolean> valid;

    public SignUpCredentialsForm() {
        credentials = new CredentialsDTO();
        buttonClick = new MutableLiveData<>();
        valid =  new MutableLiveData<>();
    }

    @Bindable
    public boolean isValid() {

        boolean valid = isEmailValid(false);
        valid = isPasswordValid(false) && valid;
        valid = isPasswordConfirmValid(false) && valid;

        notifyPropertyChanged(BR.emailError);
        notifyPropertyChanged(BR.passwordError);
        notifyPropertyChanged(BR.passwordConfirmError);

        return valid;
    }

    public boolean isEmailValid(boolean setMessage) {

        if (credentials.getEmail().getValue().matches("^[^@\\s]+[^@\\s]*@[^@.\\s]+\\.[^@.\\s]+$")){

            credentials.getEmail().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage){
                credentials.getEmail().setError(R.string.error_invalid_email);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public boolean isPasswordValid(boolean setMessage) {

        boolean validPwd = Pattern.matches("((?=.*[a-z])(?=.*\\d)(?=.*[@#$%])(?=.*[A-Z]).{8,30})", credentials.getPassword().getValue());

        if (validPwd){

            credentials.getPassword().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage) {
                credentials.getPassword().setError(R.string.error_invalid_pwd);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public boolean isPasswordConfirmValid(boolean setMessage) {

        if (credentials.getPasswordConfirm().getValue().equals(credentials.getPassword().getValue())){

            credentials.getPasswordConfirm().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage) {
                credentials.getPasswordConfirm().setError(R.string.error_invalid_pwd_confirm);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public void onClick() {

        boolean validated = isValid();
        this.valid.setValue(validated);

        if (validated) {
            buttonClick.setValue(credentials);
        }
    }

    @Bindable
    public Integer getEmailError() {
        return credentials.getEmail().getError();
    }

    @Bindable
    public Integer getPasswordError() {
        return credentials.getPassword().getError();
    }

    @Bindable
    public Integer getPasswordConfirmError() {
        return credentials.getPasswordConfirm().getError();
    }


    @Bindable
    public String getEmail() {
        return credentials.getEmail().getValue();
    }

    public void setEmail(String email) {

        if(!credentials.getEmail().getValue().equals(email)) {
            credentials.getEmail().setValue(email);
            isEmailValid(true);
        }
    }


    @Bindable
    public String getPassword() {
        return credentials.getPassword().getValue();
    }

    public void setPassword(String pwd) {

        if(!credentials.getPassword().getValue().equals(pwd)) {
            credentials.getPassword().setValue(pwd);
            isPasswordValid(true);
        }
    }

    @Bindable
    public String getPasswordConfirm() {
        return credentials.getPasswordConfirm().getValue();
    }

    public void setPasswordConfirm(String pwd) {

        if(!credentials.getPasswordConfirm().getValue().equals(pwd)) {
            credentials.getPasswordConfirm().setValue(pwd);
            isPasswordConfirmValid(true);
        }
    }

    public MutableLiveData isValidated() {
         return valid;
    }

    public CredentialsDTO getCredentials() {
        return credentials;
    }
}
