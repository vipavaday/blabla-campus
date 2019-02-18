package com.example.cedriclingom.blablacampus.activities;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends BlablaCampusActivity {

    private BottomAppBar bottomAppBar;


    private static String localMachine ="51.77.158.156";
    private static String distantMachine = "localhost";


    public static String server = "http://"+ localMachine + ":8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
