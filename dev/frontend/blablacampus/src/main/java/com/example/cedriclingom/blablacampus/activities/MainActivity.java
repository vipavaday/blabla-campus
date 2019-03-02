package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends BlablaCampusActivity {

    private BottomAppBar bottomAppBar;


    private static String localMachine ="localhost";
    private static String distantMachine = "51.77.158.156";


    public static String server = "http://"+ distantMachine + ":8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
