package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PwdForgottenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_forgotten);

        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));
    }
}
