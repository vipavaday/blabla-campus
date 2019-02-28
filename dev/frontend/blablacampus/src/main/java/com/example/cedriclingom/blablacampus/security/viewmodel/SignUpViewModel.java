package com.example.cedriclingom.blablacampus.security.viewmodel;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;
import com.example.cedriclingom.blablacampus.security.model.forms.SignUpCredentialsForm;
import com.example.cedriclingom.blablacampus.security.model.forms.SignUpSchoolForm;
import com.example.cedriclingom.blablacampus.security.model.forms.SignUpUserForm;
import com.example.cedriclingom.blablacampus.security.services.UserRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpViewModel extends ViewModel {

    private UserBundleDTO userBundle;
    private SignUpCredentialsForm credentialsForm;
    private SignUpUserForm userForm;
    private SignUpSchoolForm schoolForm;
    private MutableLiveData<Integer> accountCreated;

    public SignUpViewModel() {
        super();

        userForm = new SignUpUserForm();
        credentialsForm = new SignUpCredentialsForm();
        schoolForm = new SignUpSchoolForm();
        accountCreated = new MutableLiveData<>();

        userBundle = new UserBundleDTO(userForm.getUser(), credentialsForm.getCredentials(), schoolForm.getSchool());
    }

    public void confirmUser(){
        userForm.onClick();
    }

    public void confirmCredentials() {
        credentialsForm.onClick();
    }

    public void confirmSchool(){

        schoolForm.onClick();
        UserRepository.saveUser(userBundle, new Callback<UserBundleDTO>() {

            @Override
            public void onResponse(Call<UserBundleDTO> call, Response<UserBundleDTO> response) {

                if(response.isSuccessful()) {
                    accountCreated.setValue(R.string.account_created);
                }else if(response.code() == 409){
                    accountCreated.setValue(R.string.account_conflict);
                }else{
                    accountCreated.setValue(R.string.account_invalid_data);
                }
            }

            @Override
            public void onFailure(Call<UserBundleDTO> call, Throwable t) {

            }
        });
    }

    public SignUpUserForm getUser() {
        return userForm;
    }

    public SignUpCredentialsForm getCredentials() {
        return credentialsForm;
    }

    public SignUpSchoolForm getSchool() {
        return schoolForm;
    }


    public MutableLiveData getUserConfirmObservable() {
        return userForm.isValidated();
    }

    public MutableLiveData getCredentialsConfirmObservable() {
        return credentialsForm.isValidated();
    }

    public MutableLiveData getSchoolConfirmObservable() {
        return schoolForm.isValidated();
    }

    public MutableLiveData<Integer> getAccountCreated() {
        return accountCreated;
    }
}
