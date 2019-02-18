package com.example.cedriclingom.blablacampus.activities;

import android.app.ActionBar;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

import com.example.cedriclingom.blablacampus.R;
import com.google.android.material.textfield.TextInputEditText;

public class AuthentificationActivity extends AppCompatActivity {

    private ScrollView contentView;

    private TextInputEditText pseudo;

    private  TextInputEditText pwd;

    private LinearLayout appName;

    private TextView appNamePart1;

    private TextView appNamePart2;

    private Space spacer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));

        pseudo = findViewById(R.id.email_text);
        pwd = findViewById(R.id.password_text);
        appName = findViewById(R.id.app_name);
        contentView = findViewById(R.id.content_view);
        appNamePart1 = findViewById(R.id.app_name_part_1);
        appNamePart2 = findViewById(R.id.app_name_part_2);
        spacer = findViewById(R.id.spacer);

        onSoftKeyboardChange();
    }

    private void onSoftKeyboardChange() {

        contentView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {

            Rect r = new Rect();
            contentView.getWindowVisibleDisplayFrame(r);
            int screenHeight = contentView.getRootView().getHeight();

            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            int keypadHeight = screenHeight - r.bottom;

            if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.

                appName.setOrientation(LinearLayout.HORIZONTAL);
                appNamePart1.setTextSize(40);
                appNamePart2.setTextSize(40);
                spacer.setVisibility(View.GONE);
            }
            else {
                appName.setOrientation(LinearLayout.VERTICAL);
                appNamePart1.setTextSize(65);
                appNamePart2.setTextSize(50);
                spacer.setVisibility(View.VISIBLE);
            }
        });
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

        Intent intent = new Intent(this, PwdForgottenActivity.class);

        startActivity(intent);

    }

    public void cancelAuthentification(View v){

        finish();
    }
}
