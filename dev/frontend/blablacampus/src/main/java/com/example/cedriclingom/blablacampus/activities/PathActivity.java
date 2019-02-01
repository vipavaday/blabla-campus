package com.example.cedriclingom.blablacampus.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.PathPage1Fragment;
import com.example.cedriclingom.blablacampus.fragments.PathPage2Fragment;
import com.example.cedriclingom.blablacampus.viewPageAdapters.PathViewPagerAdapter;

public class PathActivity extends AppCompatActivity {


    private TabLayout tabLayout;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager myViewPager;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;



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



        myViewPager = (ViewPager) findViewById(R.id.path_viewPager);
        addTabs(myViewPager);

        tabLayout = (TabLayout) findViewById(R.id.path_tabs);
        //To be continued from here
        //I have to make a method that manage the tab style and z-index
        tabLayout.setupWithViewPager(myViewPager);

    }


    private void addTabs(ViewPager viewPager) {
        PathViewPagerAdapter adapter = new PathViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(PathPage1Fragment.newInstance(), "Conducteur");
        adapter.addFrag(PathPage2Fragment.newInstance(), "Passager");
        viewPager.setAdapter(adapter);
    }




    public  void showPathGraphicInterface(View view) {

        Intent intent = new Intent(this, PathActivity.class);
        startActivity(intent);

    }
}
