package com.example.cedriclingom.blablacampus.security.service;




import com.example.cedriclingom.blablacampus.security.models.ConnectionModel;
import com.example.cedriclingom.blablacampus.security.models.User;
import com.example.cedriclingom.blablacampus.security.utils.MyHttpClientService;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;




public class ConnectionService extends MyHttpClientService {

    private static User userInfos = null;

    private static  boolean  connectionStatus = false;






    public static boolean isConnected() {

        return connectionStatus != false;
    }

    public static synchronized void setConnectionStatus(boolean status){

        connectionStatus = status;
    }


    public static void doUserConnection(ConnectionModel connectionModel, AsyncHttpResponseHandler asyncHttpResponseHandler) {

        String relativeUrl = "/user/login";


        RequestParams params = new RequestParams();
        params.put("username", connectionModel.getEmail());
        params.put("password", connectionModel.getPassword());

        post(relativeUrl, params ,asyncHttpResponseHandler);

    }

}
