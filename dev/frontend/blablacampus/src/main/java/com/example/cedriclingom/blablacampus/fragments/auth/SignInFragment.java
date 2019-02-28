package com.example.cedriclingom.blablacampus.fragments.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.model.dto.CredentialsDTO;
import com.example.cedriclingom.blablacampus.security.services.ConnectionService;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.loopj.android.http.AsyncHttpResponseHandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.msebera.android.httpclient.Header;

import static android.app.Activity.RESULT_OK;

public class SignInFragment extends AuthFragment implements View.OnClickListener {

    private Button loginBtn;

    private TextInputEditText emailInput;

    private TextInputEditText pwdInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View loginFragment = inflater.inflate(R.layout.fragment_auth_sign_in, container, false);

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

        CredentialsDTO credentialsDTO = new CredentialsDTO(emailInput.getText().toString(), pwdInput.getText().toString());

        ConnectionService.signIn(credentialsDTO, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if(statusCode == 200) {

                    Log.i("loginFragment", "Request Success with statuscode: "+ statusCode);
                    ConnectionService.setConnectionStatus(true);

                    getActivity().setResult(RESULT_OK);
                    Toast connectionFailedToast  =  Toast.makeText(getActivity(), R.string.sign_in_success, Toast.LENGTH_SHORT);
                    connectionFailedToast.show();
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Log.i("loginFragment", "Request failed with status code: "+ statusCode);
                ConnectionService.setConnectionStatus(false);
                Toast connectionFailedToast  =  Toast.makeText(getActivity(), R.string.sign_in_failure, Toast.LENGTH_SHORT);
                connectionFailedToast.show();

            }
        });
    }
}
