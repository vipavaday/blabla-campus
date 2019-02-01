package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationPage2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationPage2Fragment extends Fragment {


    private static RegistrationPage2Fragment fragment;


    public RegistrationPage2Fragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RegistrationPage2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationPage2Fragment newInstance() {


         if(RegistrationPage2Fragment.fragment == null) {

             RegistrationPage2Fragment.fragment = new RegistrationPage2Fragment();

         }

        return RegistrationPage2Fragment.fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_page2, container, false);
    }


}
