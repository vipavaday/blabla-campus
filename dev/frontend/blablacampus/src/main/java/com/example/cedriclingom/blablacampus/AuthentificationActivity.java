package com.example.cedriclingom.blablacampus;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class AuthentificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);


        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));
    }


    /**
     * Montre l'interface d'inscription.
     * @param view Une vue {View}.
     */
    public void showRegistrationGraphicInterface(View view){

        Intent intent = new Intent(this, RegistrationViewpager.class);

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
}
