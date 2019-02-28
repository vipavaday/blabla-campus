package com.example.cedriclingom.blablacampus.security.utils;

import java.util.List;

import androidx.viewpager.widget.ViewPager;

public class AuthEnabledFragmentChangeListener implements ViewPager.OnPageChangeListener {

    private boolean first = true;

    private int lastPage;

    private int curPage;

    private List<AuthFragment> pages;


    public AuthEnabledFragmentChangeListener(AuthEnabledFragmentAdapter fragmentAdapter) {

        pages = fragmentAdapter.getPages();
        curPage = 0;
        lastPage = 0;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (first && positionOffset == 0 && positionOffsetPixels == 0){
            onPageSelected(0);
            first = false;
        }

        lastPage = curPage;
        curPage = position;
    }

    @Override
    public void onPageSelected(int position) {

        if(pages.get(position).isAuthentificated()) {

            pages.get(position).onAuthEnabledPageSelected();
        }
        curPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public int getLastPage() {
        return lastPage;
    }

    public int getCurrentPage() {
        return curPage;
    }
}
