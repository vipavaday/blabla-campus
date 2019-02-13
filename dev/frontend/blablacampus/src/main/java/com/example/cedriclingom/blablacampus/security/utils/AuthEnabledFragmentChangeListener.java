package com.example.cedriclingom.blablacampus.security.utils;

import android.util.Log;

import java.util.List;

import androidx.viewpager.widget.ViewPager;

public class AuthEnabledFragmentChangeListener implements ViewPager.OnPageChangeListener {

    private boolean first = true;

    private List<AuthFragment> pages;


    public AuthEnabledFragmentChangeListener(AuthEnabledFragmentAdapter fragmentAdapter) {

        pages = fragmentAdapter.getPages();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (first && positionOffset == 0 && positionOffsetPixels == 0){
            onPageSelected(0);
            first = false;
        }
    }

    @Override
    public void onPageSelected(int position) {

        if(pages.get(position).isAuthentificated()) {

            pages.get(position).onAuthEnabledPageSelected();
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
