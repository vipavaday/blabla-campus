package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


public class SignUpCredentialsFragment extends AuthFragment {

    private CoordinatorLayout avatarCL;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth_signup_credentials, container, false);

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
    public void onSoftKeyboardOpen() { avatarCL.setVisibility(View.GONE); }

    @Override
    public void onSoftKeyboardClose() { avatarCL.setVisibility(View.VISIBLE); }
}
