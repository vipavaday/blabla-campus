package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.view.View;

import com.example.cedriclingom.blablacampus.activities.OnFormValidatedListener;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public abstract class FormFragment extends AuthFragment {

    private ViewModel viewModel;
    private OnFormValidatedListener formValidatedListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupButtonClick();
    }

    public void setFormValidatedListener(OnFormValidatedListener formValidatedListener) {
        this.formValidatedListener = formValidatedListener;
    }

    protected OnFormValidatedListener getFormValidatedListener() {
        return formValidatedListener;
    }

    abstract void setupButtonClick();

    public ViewModel getViewModel() {
        return viewModel;
    }

    protected void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
