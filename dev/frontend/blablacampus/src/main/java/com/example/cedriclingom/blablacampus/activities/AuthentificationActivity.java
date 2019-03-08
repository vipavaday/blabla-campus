package com.example.cedriclingom.blablacampus.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import cz.msebera.android.httpclient.Header;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.routes.models.Route;
import com.example.cedriclingom.blablacampus.routes.service.RouteService;
import com.example.cedriclingom.blablacampus.routes.utils.RideHandler;
import com.example.cedriclingom.blablacampus.security.models.ConnectionModel;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;
import com.example.cedriclingom.blablacampus.security.service.UserService;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;

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

        addListenerOnConcetionButton();
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














    private void addListenerOnConcetionButton(){

        Button button = (Button) findViewById(R.id.connectionButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText emailView = (EditText)findViewById(R.id.connection_email_input);

                EditText pwdView = (EditText) findViewById(R.id.connection_pwd_input);

                ConnectionModel connectionModel = new ConnectionModel(emailView.getText().toString(), pwdView.getText().toString());


                ConnectionService.doUserConnection(connectionModel, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                        if(statusCode == 200) {


                            System.out.println("Success in connecting with statuscode: "+ statusCode);

                            ConnectionService.setConnectionStatus(true);

                            getUserInformations(connectionModel.getEmail());

                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        System.out.println("Failure in connecting with statuscode: "+ statusCode);

                        ConnectionService.setConnectionStatus(false);

                        String response = new String(responseBody);


                    }
                });

            }
        });

    }














    private void getUserInformations(String username){

        UserService.getUserInformations(username, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                System.out.println("Success in getting user information with statuscode: "+ statusCode);

                try {

                    UserService.setUserInfos(responseBody);

                    getUserRoutes(username);

                    setResult(RESULT_OK);

                    finish();

                } catch (JSONException e) {

                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Failure in getting user informationwith statuscode: "+ statusCode);

            }
        });

    }


    private void getUserRoutes(String username){

        RouteService.doGetUserRoutes(username, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {



                    System.out.println("The user routes were successfully taken with statusCode: " + statusCode);

                    RouteService.setUserRoutes(responseBody);

                    RideHandler.createRide
                            (
                                    "41 Boulevard François Mitterrand, 63002 Clermont-Ferrand",
                                    "1 Rue de la Chebarde, 63178 Aubière",
                                    "12 Mai 2019",
                                    "12 Mai 2019",
                                    "11",
                                    "11",
                                    AuthentificationActivity.this
                            );



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }





}
