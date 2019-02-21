package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.auth.SignInFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpCredentialsFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpSchoolFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.SignUpUserFragment;
import com.example.cedriclingom.blablacampus.security.utils.AccessDeniedHandlerFactory;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledFragmentAdapter;
import com.example.cedriclingom.blablacampus.security.utils.AuthEnabledViewPager;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SignUpActivity extends BaseActivity {

    public static final String ACCESS_DENIED_HANDLER = "SignUp_Handler";

    private AuthEnabledViewPager authEnabledViewPager;

    private ScrollView contentView;

    private TextView titleBarText;

    private ViewPager vp;

    private AuthEnabledFragmentAdapter adp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        vp = findViewById(R.id.auth_fragment_vp);

        authEnabledViewPager = new AuthEnabledViewPager(vp);
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

        titleBarText = findViewById(R.id.title_bar_text);
        contentView = findViewById(R.id.content_view);

        titleBarText.setText(getResources().getString(R.string.signup_title));
        ((ViewPager.LayoutParams) (findViewById(R.id.page_tab_strip)).getLayoutParams()).isDecor = true;
    }

    public void showSchoolPage(View v){

        vp.setCurrentItem(2);
    }

    public void showCredentialsPage(View v){

        vp.setCurrentItem(1);
    }

    public void onCancel(View v){
        finish();
    }

    @Override
    protected void onSoftKeyboardOpen() {

        getCurrentFragment().onSoftKeyboardOpen();
    }

    @Override
    protected void onSoftKeyboardClose() {

        getCurrentFragment().onSoftKeyboardClose();
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

        return (AuthFragment) adp.getItem(vp.getCurrentItem());
    }
}
