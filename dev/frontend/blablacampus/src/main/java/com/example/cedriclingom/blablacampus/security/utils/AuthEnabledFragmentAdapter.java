package com.example.cedriclingom.blablacampus.security.utils;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public abstract class AuthEnabledFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<AuthFragment> childFragments;


    public AuthEnabledFragmentAdapter(FragmentManager fm, Context ctx) {
        super(fm);

        this.context = ctx;
        childFragments = new LinkedList<>();

        initContent();
    }


    public abstract void initContent();


    protected void addChild(AuthFragment f){

        childFragments.add(f);
    }

    public List<AuthFragment> getPages() {
        return childFragments;
    }



    @Override
    public CharSequence getPageTitle(int position) {

        return context.getResources().getString(childFragments.get(position).getTitle());
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
