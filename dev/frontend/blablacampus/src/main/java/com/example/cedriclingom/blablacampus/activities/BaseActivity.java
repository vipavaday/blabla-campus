package com.example.cedriclingom.blablacampus.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

abstract class BaseActivity extends AppCompatActivity {

    private View rootView;

    private Fragment currentFragment;

    private int fragmentContainer;


    protected abstract View getRootView();
    protected abstract void onSoftKeyboardOpen();
    protected abstract void onSoftKeyboardClose();
    protected abstract int getFragmentContainer();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        rootView = getRootView();
        initSoftKeyboardChangeListener();
    }

    protected void replaceContentAreaFragment(AuthFragment f){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(getFragmentContainer(), f);
        transaction.addToBackStack(null);
        currentFragment = f;

        transaction.commit();
    }

    private void initSoftKeyboardChangeListener() {

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {

            Rect r = new Rect();
            rootView.getWindowVisibleDisplayFrame(r);
            int screenHeight = rootView.getRootView().getHeight();

            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            int keypadHeight = screenHeight - r.bottom;

            if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.

                onSoftKeyboardOpen();
            }
            else {
                onSoftKeyboardClose();
            }
        });
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
