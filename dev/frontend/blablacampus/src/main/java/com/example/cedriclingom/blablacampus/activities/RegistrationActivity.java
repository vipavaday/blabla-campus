package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.viewPageAdapters.RegistrationPageAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_viewpager);
        this.configureViewPager();

        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));


    }

    private void configureViewPager(){

        // 1 - Get ViewPager from layout

        ViewPager pager = (ViewPager)findViewById(R.id.activity_registration_viewpager);
        //Set Adapter PageAdapter and glue it together

        pager.setAdapter(new RegistrationPageAdapter(getSupportFragmentManager()));


    }
}
