package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.viewPageAdapters.RidesViewPagerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class PathActivity extends AppCompatActivity {


    private BottomAppBar bottomAppBar;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);


        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bottomAppBar);

        viewPager = findViewById(R.id.ridesCardViewpager);
        viewPager.setAdapter(new RidesViewPagerAdapter(getSupportFragmentManager(), this));

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onDriverTabClick(){


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.bottomappbar_menu, menu);

        return true;
    }

    public void closeRidesCard(View view) {

        this.finish();

    }
}
