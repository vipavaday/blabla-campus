package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.databinding.FragmentAuthSignupSchoolBinding;
import com.example.cedriclingom.blablacampus.security.viewmodel.SignUpViewModel;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class SignUpSchoolFragment extends FormFragment {

    private static final String API_KEY = "AIzaSyB78yuEKK9VTtmTx2WoWcYvT3kBZat2X0A";

    private ImageView schoolLogo;
    private Button signUpBtn;
    private boolean validated = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentAuthSignupSchoolBinding binding = FragmentAuthSignupSchoolBinding.inflate(inflater, container, false);
        setViewModel(ViewModelProviders.of(getActivity()).get(SignUpViewModel.class));
        binding.setModel((SignUpViewModel) getViewModel());

        if (!Places.isInitialized()) {
            Places.initialize(getContext(), API_KEY);
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schoolLogo = getActivity().findViewById(R.id.signup_school_logo);
        signUpBtn = getActivity().findViewById(R.id.signup_btn);
        signUpBtn.setEnabled(false);
        initAutoCompleteFragment();
    }

    private void initAutoCompleteFragment() {

        AutocompleteSupportFragment autocompleteFragment =
                (AutocompleteSupportFragment) getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG));
        autocompleteFragment.setHint(getResources().getString(R.string.school_hint));
        autocompleteFragment.setCountry("fr");
        autocompleteFragment.setTypeFilter(TypeFilter.ESTABLISHMENT);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                ((SignUpViewModel)getViewModel()).getSchool().setLocation(place);
                Log.i("a", "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("a", "An error occurred: " + status);
            }
        });
    }

    @Override
    public int getTitle() {
        return R.string.signup_school_title;
    }

    @Override
    public void onSoftKeyboardOpen() {

        if(schoolLogo != null) {
            schoolLogo.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSoftKeyboardClose() {

        if(schoolLogo != null) {
            schoolLogo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    void setupButtonClick() {

        ((SignUpViewModel)getViewModel()).getSchoolConfirmObservable().observe(this, validated -> {

            if (getFormValidatedListener() != null && (Boolean) validated != this.validated) {

                getFormValidatedListener().onFormValidated();
                this.validated = (Boolean) validated;
            }
        });

        ((SignUpViewModel)getViewModel()).getAccountCreated().observe(this, message ->{
            Toast.makeText(getActivity(),getResources().getString(message),Toast.LENGTH_SHORT).show();
        });
    }
}
