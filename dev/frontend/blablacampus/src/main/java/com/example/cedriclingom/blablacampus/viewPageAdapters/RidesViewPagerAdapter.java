package com.example.cedriclingom.blablacampus.viewPageAdapters;

import android.content.Context;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.activities.PathActivity;
import com.example.cedriclingom.blablacampus.fragments.DriverRidesFragment;
import com.example.cedriclingom.blablacampus.fragments.PassengerRidesFragment;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;

import java.util.LinkedList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class RidesViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    private List<Fragment> childFragments;

    private List<String> childNames;

    public RidesViewPagerAdapter(FragmentManager fm, Context ctx) {

        super(fm);
        this.context = ctx;

        childFragments = new LinkedList<>();
        childNames = new LinkedList<>();

        addChild(new PassengerRidesFragment(), ctx.getResources().getString(R.string.tab_item_passager));
        addChild(new DriverRidesFragment(), ctx.getResources().getString(R.string.tab_item_conducteur));

    }

    private void addChild(Fragment f, String name){

        childFragments.add(f);
        childNames.add(name);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return childNames.get(position);
    }

    @Override
    public Fragment getItem(int position) {

        return childFragments.get(position);
    }

    @Override
    public int getCount() {

        return childFragments.size();
    }
}
