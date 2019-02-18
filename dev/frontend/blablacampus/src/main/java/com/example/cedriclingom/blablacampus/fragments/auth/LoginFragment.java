package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.models.ConnectionModel;
import com.example.cedriclingom.blablacampus.security.service.ConnectionService;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.loopj.android.http.AsyncHttpResponseHandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.msebera.android.httpclient.Header;

import static android.app.Activity.RESULT_OK;

public class LoginFragment extends AuthFragment implements View.OnClickListener {

    private Button loginBtn;

    private TextInputEditText emailInput;

    private TextInputEditText pwdInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View loginFragment = inflater.inflate(R.layout.fragment_auth_login, container, false);

        return loginFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailInput = getActivity().findViewById(R.id.email_text);
        pwdInput = getActivity().findViewById(R.id.password_text);
        loginBtn = getActivity().findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public int getTitle() {

        return R.string.login_title;
    }

    @Override
    public void onClick(View v) {

        ConnectionModel connectionModel = new ConnectionModel(emailInput.getText().toString(), pwdInput.getText().toString());

        ConnectionService.doUserConnection(connectionModel, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if(statusCode == 200) {

                    Log.i("loginFragment", "Request Success with statuscode: "+ statusCode);
                    ConnectionService.setConnectionStatus(true);

                    getActivity().setResult(RESULT_OK);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Log.i("loginFragment", "Request failed with status code: "+ statusCode);
                ConnectionService.setConnectionStatus(false);

            }
        });
    }
}
