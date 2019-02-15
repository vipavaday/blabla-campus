package com.example.cedriclingom.blablacampus.security.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cedriclingom.blablacampus.activities.AuthentificationActivity;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public abstract class AuthFragment extends Fragment {

    static final int PICK_USER_REQUEST = 1;

    private IAccessAuthHandler accessAuthHandler;

    private boolean auth;

    private Bundle bundle;


    public AuthFragment() {
        super();

        auth = true;
        bundle = new Bundle();

        bundle.putBoolean("auth", auth);
        setArguments(bundle);
    }

    public void onAuthEnabledPageSelected() {

        testUserConnection();
    }

    public boolean isAuthentificated() {
        return auth;
    }


    private void testUserConnection(){

        if(!ConnectionService.isConnected()){

            showConnectionCard();
        }
    }

    private  void showConnectionCard() {

        Intent intent =  new Intent(this.getActivity(), AuthentificationActivity.class);

        startActivityForResult(intent, PICK_USER_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check which request we're responding to
        if (requestCode == PICK_USER_REQUEST) {

            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                this.accessAuthHandler.onAccessAccepted();

            }else if(resultCode == RESULT_CANCELED){

                this.accessAuthHandler.onAccessDenied();

            }
        }
    }

    public boolean isAuth() {
        return auth;
    }

    protected void setAuth(boolean auth) {

        this.auth = auth;
        bundle.putBoolean("auth", auth);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bdl = getArguments();

        if (bdl != null) {
            auth = bdl.getBoolean("auth");
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void setAccessDeniedHandler(IAccessAuthHandler accessDeniedHandler) {
        this.accessAuthHandler = accessDeniedHandler;
    }
}
