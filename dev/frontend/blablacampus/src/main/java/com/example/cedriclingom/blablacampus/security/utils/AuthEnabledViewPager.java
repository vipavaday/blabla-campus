package com.example.cedriclingom.blablacampus.security.utils;

import androidx.viewpager.widget.ViewPager;

public class AuthEnabledViewPager implements IAccessAuthHandler {


    private ViewPager vp;
    private AuthEnabledFragmentChangeListener changeListener;

    public AuthEnabledViewPager(ViewPager vp) {

        this.vp = vp;
    }


    @Override
    public void onAccessDenied() {

        vp.setCurrentItem(changeListener.getLastPage());
    }

    @Override
    public void onAccessAccepted() {
        vp.setCurrentItem(changeListener.getCurrentPage());
    }

    public ViewPager getViewPager() {
        return vp;
    }

    public void  setAdapter(AuthEnabledFragmentAdapter adp){

        vp.setAdapter(adp);
        changeListener = new AuthEnabledFragmentChangeListener(adp);
        vp.addOnPageChangeListener(changeListener);
    }
}
