package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.main.HomeFragment;
import com.example.cedriclingom.blablacampus.fragments.main.RidesFragment;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.core.content.ContextCompat;

public class BlablaCampusActivity extends BaseActivity {

    private BottomAppBar bottomAppBar;

    private RelativeLayout contentArea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        setContentView(R.layout.activity_blablacampus);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        contentArea = findViewById(R.id.content_area);
        setSupportActionBar(bottomAppBar);

        replaceContentAreaFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.bottomappbar_menu, menu);

        return true;
    }

    public void showRideCard(View view) {

        AuthFragment f = (getCurrentFragment() instanceof RidesFragment)? new HomeFragment() : new RidesFragment();
        replaceContentAreaFragment(f);
    }

    public void showHomePage(View v){

        replaceContentAreaFragment(new HomeFragment());
    }

    @Override
    protected View getRootView() {
        return contentArea;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.content_area;
    }
}
