package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class SignUpSchoolFragment extends AuthFragment {

    private ImageView schoolLogo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_auth_signup_school, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schoolLogo = getActivity().findViewById(R.id.signup_school_logo);
    }

    @Override
    public int getTitle() {
        return R.string.signup_school_title;
    }

    @Override
    public void onSoftKeyboardOpen() { schoolLogo.setVisibility(View.GONE); }

    @Override
    public void onSoftKeyboardClose() { schoolLogo.setVisibility(View.VISIBLE); }
}
