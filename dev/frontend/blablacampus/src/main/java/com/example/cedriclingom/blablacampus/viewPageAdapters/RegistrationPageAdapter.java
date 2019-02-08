package com.example.cedriclingom.blablacampus.viewPageAdapters;

import com.example.cedriclingom.blablacampus.fragments.RegistrationPage1Fragment;
import com.example.cedriclingom.blablacampus.fragments.RegistrationPage2Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by cedric.lingom on 22/01/2019.
 */

public class RegistrationPageAdapter extends FragmentPagerAdapter {

    private static final int numberOfPages = 2;



    public RegistrationPageAdapter(FragmentManager fm) {

        super(fm);

    }


    @Override

    public Fragment getItem(int position) {

        switch (position){

            case 0: //Page number 1

                return RegistrationPage1Fragment.newInstance();

            case 1: //Page number 2

                return RegistrationPage2Fragment.newInstance();

            default:

                return null;

        }

    }

    //Nous renvoie le nombre de pages.
    @Override
    public int getCount() {

        return RegistrationPageAdapter.numberOfPages;

    }
}
