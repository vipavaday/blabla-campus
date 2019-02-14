package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.View;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.DriverRidesFragment;
import com.example.cedriclingom.blablacampus.fragments.PassengerRidesFragment;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentChangeListener;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledViewPager;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

public class PathActivity extends BlablaCampusActivity {


    private AuthEnabledViewPager authEnabledViewPager;

    private TabLayout tabLayout;

    public static final String ACCESS_DENIED_HANDLER = "Rides_Handler";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setBottomAppBar(findViewById(R.id.bottom_app_bar));
        setSupportActionBar(getBottomAppBar());
        setContentView(R.layout.activity_path);

        ViewPager vp = findViewById(R.id.ridesCardViewpager);

        authEnabledViewPager = new AuthEnabledViewPager(vp);
        AccessDeniedHandlerFactory.addAccessDeniedHandler(ACCESS_DENIED_HANDLER, authEnabledViewPager);

        AuthEnabledFragmentAdapter adp = new AuthEnabledFragmentAdapter(getSupportFragmentManager(), this) {

            @Override
            public void initContent() {
                addChild(new PassengerRidesFragment(), getResources().getString(R.string.tab_item_passager));
                addChild(new DriverRidesFragment(), getResources().getString(R.string.tab_item_conducteur));
            }
        };

        authEnabledViewPager.setAdapter(adp);



        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(authEnabledViewPager.getViewPager());
    }

    public void closeRidesCard(View view) {

        this.finish();

    }


}
