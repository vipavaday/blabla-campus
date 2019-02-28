package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.databinding.FragmentAuthSignupCredentialsBinding;
import com.example.cedriclingom.blablacampus.security.viewmodel.SignUpViewModel;

import java.util.Observable;
import java.util.Observer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;


public class SignUpCredentialsFragment extends FormFragment {

    private CoordinatorLayout avatarCL;
    private boolean validated = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentAuthSignupCredentialsBinding binding = FragmentAuthSignupCredentialsBinding.inflate(inflater, container, false);
        setViewModel(ViewModelProviders.of(getActivity()).get(SignUpViewModel.class));
        binding.setModel((SignUpViewModel) getViewModel());

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        avatarCL = getActivity().findViewById(R.id.avatarCL2);
    }

    @Override
    public int getTitle() {
        return R.string.signup_credentials_title;
    }

    @Override
    public void onSoftKeyboardOpen() {
        if(avatarCL != null){
            avatarCL.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSoftKeyboardClose() {

        if (avatarCL != null) {
            avatarCL.setVisibility(View.VISIBLE);
        }
    }

    @Override
    void setupButtonClick() {

        ((SignUpViewModel)getViewModel()).getCredentialsConfirmObservable().observe(this, validated -> {

            if (getFormValidatedListener() != null && (Boolean) validated!= this.validated) {

                getFormValidatedListener().onFormValidated();
                this.validated = (Boolean)validated;
            }
        });
    }
}
