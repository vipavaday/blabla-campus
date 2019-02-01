package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;

/**
 * Created by cedric.lingom on 01/02/2019.
 */
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PathPage2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PathPage2Fragment extends Fragment {


    private static PathPage2Fragment fragment;







    public PathPage2Fragment() {}






    /**
     *
     * @return Un fragment {PathPage2Fragment}
     */
    public static PathPage2Fragment getFragment() {
        return fragment;
    }


    /**
     * Met à jour le fragment.
     * @param fragment Le nouveau fragment {PathPage2Fragment}
     */
    public static void setFragment(PathPage2Fragment fragment) {
        PathPage2Fragment.fragment = fragment;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RegistrationPage1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static  PathPage2Fragment newInstance() {

        if( PathPage2Fragment.fragment == null){

            PathPage2Fragment.fragment = new  PathPage2Fragment();
        }

        return  PathPage2Fragment.fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_path_page1, container, false);

    }

}



