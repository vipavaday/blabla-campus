package com.example.cedriclingom.blablacampus.security.utils;





import com.example.cedriclingom.blablacampus.activities.MainActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;



public class HttpClientService {

    private static final String baseUrl = MainActivity.server;

    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setEnableRedirects(true);
    }


    public static String getbaseUrl() {
        return baseUrl;
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return baseUrl + relativeUrl;
    }

    public static void get(String url, RequestParams params,AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);

    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static AsyncHttpClient getClient(){

        return client;
    }


}
