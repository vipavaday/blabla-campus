package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.DriverRidesFragment;
import com.example.cedriclingom.blablacampus.fragments.PassengerRidesFragment;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentChangeListener;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class PathActivity extends BlablaCampusActivity {


    private ViewPager viewPager;

    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setBottomAppBar(findViewById(R.id.bottom_app_bar));
        setSupportActionBar(getBottomAppBar());
        setContentView(R.layout.activity_path);
        viewPager = findViewById(R.id.ridesCardViewpager);

        AuthEnabledFragmentAdapter adp = new AuthEnabledFragmentAdapter(getSupportFragmentManager(), this) {

            @Override
            public void initContent() {
                addChild(new PassengerRidesFragment(), getResources().getString(R.string.tab_item_passager));
                addChild(new DriverRidesFragment(), getResources().getString(R.string.tab_item_conducteur));
            }
        };

        viewPager.setAdapter(adp);
        viewPager.addOnPageChangeListener(new AuthEnabledFragmentChangeListener(adp));

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void closeRidesCard(View view) {

        this.finish();

    }


}
