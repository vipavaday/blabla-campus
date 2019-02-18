package com.example.cedriclingom.blablacampus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledViewPager;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class RidesFragment extends Fragment {

    private AuthEnabledViewPager authEnabledViewPager;

    private TabLayout tabLayout;

    public static final String ACCESS_DENIED_HANDLER = "Rides_Handler";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View bottomAppBarCL = inflater.inflate(R.layout.fragment_rides, container, false);

        ViewPager vp = bottomAppBarCL.findViewById(R.id.ridesCardViewpager);

        authEnabledViewPager = new AuthEnabledViewPager(vp);
        AccessDeniedHandlerFactory.addAccessDeniedHandler(ACCESS_DENIED_HANDLER, authEnabledViewPager);

        AuthEnabledFragmentAdapter adp = new AuthEnabledFragmentAdapter(getChildFragmentManager(), getContext()) {

            @Override
            public void initContent() {
                addChild(new PassengerRidesFragment(), getResources().getString(R.string.tab_item_passager));
                addChild(new DriverRidesFragment(), getResources().getString(R.string.tab_item_conducteur));
            }
        };

        authEnabledViewPager.setAdapter(adp);

        tabLayout = bottomAppBarCL.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(authEnabledViewPager.getViewPager());

        return bottomAppBarCL;
    }
}
