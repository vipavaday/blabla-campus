package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationPage1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationPage1Fragment extends Fragment {

    private static RegistrationPage1Fragment fragment;






    public RegistrationPage1Fragment() {}





    /**
     *
     * @return Un fragment {RegistrationPage1Fragment}
     */
    public static RegistrationPage1Fragment getFragment() {
        return fragment;
    }


    /**
     * Met à jour le fragment.
     * @param fragment Le nouveau fragment {RegistrationPage1Fragment}
     */
    public static void setFragment(RegistrationPage1Fragment fragment) {
        RegistrationPage1Fragment.fragment = fragment;
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RegistrationPage1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationPage1Fragment newInstance() {

        if(RegistrationPage1Fragment.fragment == null){

            RegistrationPage1Fragment.fragment = new RegistrationPage1Fragment();
        }

        return RegistrationPage1Fragment.fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_page1, container, false);

    }




}