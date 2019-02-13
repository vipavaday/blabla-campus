package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager;

import com.example.cedriclingom.blablacampus.R;
import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public abstract class BlablaCampusActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blablaCampuspurple));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.bottomappbar_menu, menu);

        return true;
    }

    public BottomAppBar getBottomAppBar() {
        return bottomAppBar;
    }

    public void setBottomAppBar(BottomAppBar bottomAppBar) {
        this.bottomAppBar = bottomAppBar;
    }
}
