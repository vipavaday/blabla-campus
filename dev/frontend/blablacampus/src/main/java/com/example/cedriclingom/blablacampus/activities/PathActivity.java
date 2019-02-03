package com.example.cedriclingom.blablacampus.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;

import android.view.ViewGroup;
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
        drawTabs();
        tabLayout.setupWithViewPager(myViewPager);


    }


    private void addTabs(ViewPager viewPager) {
        PathViewPagerAdapter adapter = new PathViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(PathPage1Fragment.newInstance(), "Conducteur");
        adapter.addFrag(PathPage2Fragment.newInstance(), "Passager");
        viewPager.setAdapter(adapter);
    }


    private void overlapTabs() {

        findViewById(R.id.passengerItem).bringToFront();
    }


    private void setTabBG(int tab1, int tab2){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            ViewGroup tabStrip = (ViewGroup) tabLayout.getChildAt(0);
            View tabView1 = tabStrip.getChildAt(0);
            View tabView2 = tabStrip.getChildAt(1);
            if (tabView1 != null) {
                int paddingStart = tabView1.getPaddingStart();
                int paddingTop = tabView1.getPaddingTop();
                int paddingEnd = tabView1.getPaddingEnd();
                int paddingBottom = tabView1.getPaddingBottom();
                ViewCompat.setBackground(tabView1, AppCompatResources.getDrawable(tabView1.getContext(), tab1));
                //ViewCompat.setPaddingRelative(tabView1, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }

            if (tabView2 != null) {
                int paddingStart = tabView2.getPaddingStart();
                int paddingTop = tabView2.getPaddingTop();
                int paddingEnd = tabView2.getPaddingEnd();
                int paddingBottom = tabView2.getPaddingBottom();
                ViewCompat.setBackground(tabView2, AppCompatResources.getDrawable(tabView2.getContext(), tab2));
                //ViewCompat.setPaddingRelative(tabView2, paddingStart, paddingTop, paddingEnd, paddingBottom);
            }
        }
    }

    private void chooseUnselectedTab(int position){

        ViewGroup tabStrip = (ViewGroup) tabLayout.getChildAt(0);
        tabStrip.getChildAt(position).setSelected(false);

    }

    private void chooseinitialSelectedTab(int position){

        ViewGroup tabStrip = (ViewGroup) tabLayout.getChildAt(0);
        tabStrip.getChildAt(position).setSelected(true);

    }

    private void drawTabs(){

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getSelectedTabPosition()==0) {
                    setTabBG(R.drawable.bg_path_tab_selected, R.drawable.bg_path_tab_unselected);
                }
                else {
                    setTabBG(R.drawable.bg_path_tab_unselected, R.drawable.bg_path_tab_selected);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){

                if(tabLayout.getSelectedTabPosition()==0) {
                    setTabBG(R.drawable.bg_path_tab_selected, R.drawable.bg_path_tab_unselected);
                }
                else {
                    setTabBG(R.drawable.bg_path_tab_unselected, R.drawable.bg_path_tab_selected);
                }

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){

                /*if(tabLayout.getSelectedTabPosition()==0) {
                    setTabBG(R.drawable.bg_path_tab_unselected, 1);
                }
                else {
                    setTabBG(R.drawable.bg_path_tab_unselected, 0);
                }*/

            }
        });

    }


    public  void showPathGraphicInterface(View view) {

        Intent intent = new Intent(this, PathActivity.class);
        startActivity(intent);

    }
}
