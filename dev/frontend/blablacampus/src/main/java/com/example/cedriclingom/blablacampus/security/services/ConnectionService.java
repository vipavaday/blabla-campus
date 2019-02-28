package com.example.cedriclingom.blablacampus.security.services;




import com.example.cedriclingom.blablacampus.security.model.dto.CredentialsDTO;
import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;
import com.example.cedriclingom.blablacampus.security.utils.HttpClientService;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;




public class ConnectionService extends HttpClientService {

    private static UserBundleDTO userInfos = null;

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
        params.put("username", credentialsDTO.getEmail().getValue());
        params.put("password", credentialsDTO.getPassword().getValue());

        ConnectionService.post(relativeUrl, params ,asyncHttpResponseHandler);

    }

}
