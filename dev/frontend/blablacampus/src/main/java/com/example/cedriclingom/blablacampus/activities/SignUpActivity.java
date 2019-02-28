package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.activities.utils.TabLayoutUtils;
import com.example.cedriclingom.blablacampus.fragments.auth.FormFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpCredentialsFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpSchoolFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpUserFragment;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledViewPager;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class SignUpActivity extends BaseActivity implements OnFormValidatedListener{

    public static final String ACCESS_DENIED_HANDLER = "SignUp_Handler";

    private AuthEnabledViewPager authEnabledViewPager;
    private ScrollView contentView;
    private TextView titleBarText;
    private TabLayout bulletTabLayout;
    private AuthEnabledFragmentAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_auth);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        authEnabledViewPager = findViewById(R.id.auth_fragment_vp);
        AccessDeniedHandlerFactory.addAccessDeniedHandler(ACCESS_DENIED_HANDLER, authEnabledViewPager);

        adp = new AuthEnabledFragmentAdapter(getSupportFragmentManager(), this) {

            @Override
            public void initContent() {
                addChild(new SignUpUserFragment());
                addChild(new SignUpCredentialsFragment());
                addChild(new SignUpSchoolFragment());
            }
        };

        authEnabledViewPager.setAdapter(adp);
        authEnabledViewPager.setLocked(true);

        titleBarText = findViewById(R.id.title_bar_text);
        contentView = findViewById(R.id.content_view);
        bulletTabLayout = findViewById(R.id.bullet_tab_layout);
        TabLayoutUtils.enableTabs( bulletTabLayout, false );

        titleBarText.setText(getResources().getString(R.string.signup_title));
        ((ViewPager.LayoutParams) (findViewById(R.id.bullet_tab_layout)).getLayoutParams()).isDecor = true;
    }

    public void onCancel(View v){
        finish();
    }

    @Override
    protected void onSoftKeyboardOpen() {

        getCurrentFragment().onSoftKeyboardOpen();

        if (bulletTabLayout !=null){
            bulletTabLayout.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSoftKeyboardClose() {

        getCurrentFragment().onSoftKeyboardClose();

        if (bulletTabLayout !=null){
            bulletTabLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected View getRootView() {
        return contentView;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.auth_fragment_holder;
    }

    @Override
    public AuthFragment getCurrentFragment() {

        return (AuthFragment) adp.getItem(authEnabledViewPager.getCurrentItem());
    }

    @Override
    public void onAttachFragment(Fragment fragment) {

        if (fragment instanceof FormFragment) {
            FormFragment formFragment = (FormFragment) fragment;
            formFragment.setFormValidatedListener(this);
        }
    }

    @Override
    public void onFormValidated() {

        if(authEnabledViewPager.getCurrentItem() < authEnabledViewPager.getChildCount()){
            authEnabledViewPager.setCurrentItem(authEnabledViewPager.getCurrentItem()+1);
        }

    }
}
