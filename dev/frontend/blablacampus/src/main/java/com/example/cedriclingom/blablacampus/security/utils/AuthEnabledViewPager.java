package com.example.cedriclingom.blablacampus.security.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class AuthEnabledViewPager extends ViewPager implements IAccessAuthHandler {

    private AuthEnabledFragmentChangeListener changeListener;
    private boolean locked;

    public AuthEnabledViewPager(@NonNull Context context) {
        super(context);
        locked = true;
    }

    public AuthEnabledViewPager(@NonNull Context context, AttributeSet attributes) {
        super(context, attributes);
        locked = true;
    }

    @Override
    public void onAccessDenied() {

        setCurrentItem(changeListener.getLastPage());
    }

    @Override
    public void onAccessGranted() {
        setCurrentItem(changeListener.getCurrentPage());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return locked ? false : super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return locked ? false : super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return locked ? false : super.performClick();
    }



    public void  setAdapter(AuthEnabledFragmentAdapter adp){

        super.setAdapter(adp);
        changeListener = new AuthEnabledFragmentChangeListener(adp);
        addOnPageChangeListener(changeListener);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
