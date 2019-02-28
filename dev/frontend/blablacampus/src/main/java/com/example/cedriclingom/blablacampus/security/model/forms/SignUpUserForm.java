package com.example.cedriclingom.blablacampus.security.model.forms;

import com.example.cedriclingom.blablacampus.BR;
import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.model.dto.UserDTO;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class SignUpUserForm extends BaseObservable {

    private UserDTO user;
    private MutableLiveData<UserDTO> buttonClick;
    private MutableLiveData<Boolean> valid;

    public SignUpUserForm() {

        user = new UserDTO();
        buttonClick = new MutableLiveData<>();
        valid = new MutableLiveData<>();
    }

    @Bindable
    public boolean isValid() {

        boolean valid = isFirstnameValid(false);
        valid = isLastnameValid(false) && valid;
        valid = isPhoneValid(false) && valid;

        notifyPropertyChanged(BR.firstnameError);
        notifyPropertyChanged(BR.lastnameError);
        notifyPropertyChanged(BR.phoneError);

        return valid;
    }

    public boolean isFirstnameValid(boolean setMessage) {

        if (user.getFirstname().getValue().matches("^(\\p{L}){3}(\\p{L})*$")){

            user.getFirstname().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage){
                user.getFirstname().setError(R.string.error_invalid_name);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public boolean isLastnameValid(boolean setMessage) {

        if (user.getLastname().getValue().matches("^(\\p{L}){3}(\\p{L})*$")){

            user.getLastname().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage) {
                user.getLastname().setError(R.string.error_invalid_name);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public boolean isPhoneValid(boolean setMessage) {

        if (user.getPhone().getValue().replace(" ", "")
                .matches("(^\\+[0-9]{2}[0-9]{9})|([0-9]{10})")){

            user.getPhone().clearError();
            notifyPropertyChanged(BR.valid);

            return true;

        }else{

            if(setMessage) {
                user.getPhone().setError(R.string.error_invalid_phone);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public void onClick() {

        boolean validated = isValid();
        this.valid.setValue(validated);

        if (validated) {
            buttonClick.setValue(user);
        }
    }

    public MutableLiveData<Boolean> isValidated() {
        return valid;
    }

    @Bindable
    public Integer getFirstnameError() {
        return user.getFirstname().getError();
    }

    @Bindable
    public Integer getLastnameError() {
        return user.getLastname().getError();
    }

    @Bindable
    public Integer getPhoneError() {
        return user.getPhone().getError();
    }


    @Bindable
    public String getFirstname() {
        return user.getFirstname().getValue();
    }

    public void setFirstname(String value) {

        if(!user.getFirstname().getValue().equals(value)) {
            user.getFirstname().setValue(value);
            isFirstnameValid(true);
        }
    }


    @Bindable
    public String getLastname() {
        return user.getLastname().getValue();
    }

    public void setLastname(String value) {

        if(!user.getLastname().getValue().equals(value)) {
            user.getLastname().setValue(value);
            isLastnameValid(true);
        }
    }


    @Bindable
    public String getPhone() {
        return user.getPhone().getValue();
    }

    public void setPhone(String value) {

        if(!user.getPhone().getValue().equals(value)) {
            user.getPhone().setValue(value);
            isPhoneValid(true);
        }
    }

    public UserDTO getUser() {
        return user;
    }
}
