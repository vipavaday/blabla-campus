package com.example.cedriclingom.blablacampus.security.service;




import com.example.cedriclingom.blablacampus.security.models.CredentialsDTO;
import com.example.cedriclingom.blablacampus.security.models.UserDTO;
import com.example.cedriclingom.blablacampus.security.utils.HttpClientService;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;




public class ConnectionService extends HttpClientService {

    private static UserDTO userInfos = null;

    private static  boolean  connectionStatus = false;


    public static boolean isConnected() {

        return connectionStatus != false;
    }

    public static synchronized void setConnectionStatus(boolean status){

        connectionStatus = status;
    }


    public static void signIn(CredentialsDTO credentialsDTO, AsyncHttpResponseHandler asyncHttpResponseHandler) {

        String relativeUrl = "/user/login";


        RequestParams params = new RequestParams();
        params.put("username", credentialsDTO.getEmail());
        params.put("password", credentialsDTO.getPassword());

        ConnectionService.post(relativeUrl, params ,asyncHttpResponseHandler);

    }

}
