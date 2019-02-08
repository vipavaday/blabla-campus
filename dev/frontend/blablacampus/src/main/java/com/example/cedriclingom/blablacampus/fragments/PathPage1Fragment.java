package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;

import androidx.fragment.app.Fragment;

/**
 * Created by cedric.lingom on 01/02/2019.
 */
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PathPage1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PathPage1Fragment extends Fragment {


    private static PathPage1Fragment fragment;







    public PathPage1Fragment() {}






    /**
     *
     * @return Un fragment {PathPage1Fragment}
     */
    public static PathPage1Fragment getFragment() {
        return fragment;
    }


    /**
     * Met à jour le fragment.
     * @param fragment Le nouveau fragment {PathPage1Fragment}
     */
    public static void setFragment(PathPage1Fragment fragment) {
        PathPage1Fragment.fragment = fragment;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RegistrationPage1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static  PathPage1Fragment newInstance() {

        if( PathPage1Fragment.fragment == null){

            PathPage1Fragment.fragment = new  PathPage1Fragment();
        }

        return  PathPage1Fragment.fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_path_page1, container, false);

    }

}
