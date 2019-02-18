package com.example.cedriclingom.blablacampus.activities;

import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.HomeFragment;
import com.example.cedriclingom.blablacampus.fragments.RidesFragment;
import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class BlablaCampusActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;

    private FragmentPage currentFragment;

    private enum FragmentPage {
        RIDES,
        HOME
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        setContentView(R.layout.activity_blablacampus);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bottomAppBar);

        replaceContentAreaFragment(new HomeFragment(), FragmentPage.HOME);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.bottomappbar_menu, menu);

        return true;
    }

    public void showRideCard(View view) {

        if(currentFragment != FragmentPage.RIDES) {
            replaceContentAreaFragment(new RidesFragment(), FragmentPage.RIDES);
        }else{
            replaceContentAreaFragment(new HomeFragment(), FragmentPage.HOME);
        }
    }


    private void replaceContentAreaFragment(Fragment f, FragmentPage page){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_area, f);
        transaction.addToBackStack(null);

        transaction.commit();
        currentFragment = page;
    }
}
