package com.example.cedriclingom.blablacampus.security.utils;





import android.content.Context;

import com.example.cedriclingom.blablacampus.activities.MainActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Locale;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;


public class MyHttpClientService {

    private static final String baseUrl = MainActivity.server;

    private static AsyncHttpClient client = new AsyncHttpClient();

    private static PersistentCookieStore myCookieStore;









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
    public static void postEntity(Context context, String url, StringEntity stringEntity, AsyncHttpResponseHandler responseHandler) {


        client.post(context, getAbsoluteUrl(url),stringEntity, "application/json", responseHandler);

    }

    public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

        client.put(getAbsoluteUrl(url), params, responseHandler);

    }

    public static AsyncHttpClient getClient(){

        return client;

    }



}
