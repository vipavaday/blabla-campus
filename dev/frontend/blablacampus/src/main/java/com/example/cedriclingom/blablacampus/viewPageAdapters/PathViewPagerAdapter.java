package com.example.cedriclingom.blablacampus.viewPageAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedric.lingom on 01/02/2019.
 */

public class PathViewPagerAdapter extends FragmentPagerAdapter{


    private final List<Fragment> mFragmentList = new ArrayList<>();

    private final List<String> mFragmentTitleList = new ArrayList<>();






    /**
     * Constructor for the PathPageAdapter.
     * @param manager  Le manageur de fragments.
     */
    public PathViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }





    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


    /**
     * Ajoutes les fragments ainsi que les titres de fragments dans leurs listes respectives.
     * @param fragment   Le fragment à ajouter à la liste.
     * @param title      Le titre de de chaaque fragment ajouté.
     */
    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}
