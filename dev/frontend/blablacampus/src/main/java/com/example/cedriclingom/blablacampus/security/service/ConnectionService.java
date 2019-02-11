package com.example.cedriclingom.blablacampus.security.service;




import com.example.cedriclingom.blablacampus.security.models.UserModel;



public final class ConnectionService {

    private static  UserModel userInfos = null;




    public static boolean isConnected() {

         return userInfos != null;
    }




    public static void doUserConnection() {

    }


}
