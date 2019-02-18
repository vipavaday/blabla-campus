package com.example.cedriclingom.blablacampus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import cz.msebera.android.httpclient.Header;
import com.example.cedriclingom.blablacampus.security.models.ConnectionModel;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;
import com.loopj.android.http.AsyncHttpResponseHandler;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.fragments.auth.ForgottenPwdFragment;
import com.example.cedriclingom.blablacampus.fragments.auth.LoginFragment;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;

import androidx.core.content.ContextCompat;

public class AuthentificationActivity extends BaseActivity {

    private ScrollView contentView;


    private LinearLayout appName;

    private TextView appNamePart1;
    private TextView appNamePart2;

    private TextView titleBarText;

    private Space spacerTop;
    private Space spacerBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authentification);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        appName = findViewById(R.id.app_name);
        contentView = findViewById(R.id.content_view);
        appNamePart1 = findViewById(R.id.app_name_part_1);
        appNamePart2 = findViewById(R.id.app_name_part_2);
        titleBarText = findViewById(R.id.title_bar_text);
        spacerTop = findViewById(R.id.spacer_top);
        spacerBottom = findViewById(R.id.spacer_bottom);


        replaceContentAreaFragment(new LoginFragment());
    }

    @Override
    protected View getRootView() {

        return contentView;
    }

    @Override
    protected void onSoftKeyboardOpen() {

        appName.setOrientation(LinearLayout.HORIZONTAL);
        appNamePart1.setTextSize(40);
        appNamePart2.setTextSize(40);
        spacerTop.setVisibility(View.GONE);
        spacerBottom.setVisibility(View.GONE);
    }

    @Override
    protected void onSoftKeyboardClose() {

        appName.setOrientation(LinearLayout.VERTICAL);
        appNamePart1.setTextSize(65);
        appNamePart2.setTextSize(50);
        spacerTop.setVisibility(View.VISIBLE);
        spacerBottom.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.auth_fragment_holder;
    }

    /**
     * Montre l'interface d'inscription.
     * @param view Une vue {View}.
     */
    public void showRegistrationGraphicInterface(View view){

        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);

    }

    /**
     * Montre l'interface de renvoie d'un nouveau.
     * @param view Une vue {View}.
     */
    public void showPwdForgottenGraphicInterface(View view){

        AuthFragment f = new ForgottenPwdFragment();
        replaceContentAreaFragment(f);
    }

    public void onCancel(View v){

        if(getCurrentFragment() instanceof ForgottenPwdFragment){

            replaceContentAreaFragment(new LoginFragment());

        }else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void replaceContentAreaFragment(AuthFragment f) {

        super.replaceContentAreaFragment(f);
        titleBarText.setText(f.getTitle());
    }

    public void connection(View v){

    }
}
