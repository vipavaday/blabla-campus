package com.example.cedriclingom.blablacampus.security.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class AccessDeniedHandlerFactory {

    private static Map<String, IAccessAuthHandler> handlers =  new HashMap<>();

    public static IAccessAuthHandler getHandler(String handlerName){

        return handlers.get(handlerName);
    }

    public static void addAccessDeniedHandler(String handlerName, IAccessAuthHandler handler){

        handlers.put(handlerName, handler);
    }
}
