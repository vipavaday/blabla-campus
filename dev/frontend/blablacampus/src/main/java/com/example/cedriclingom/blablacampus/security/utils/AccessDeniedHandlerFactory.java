package com.example.cedriclingom.blablacampus.security.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class AccessDeniedHandlerFactory {

    private static Map<String, IAccessDeniedHandler> handlers =  new HashMap<>();

    public static IAccessDeniedHandler getHandler(String handlerName){

        return handlers.get(handlerName);
    }

    public static void addAccessDeniedHandler(String handlerName, IAccessDeniedHandler handler){

        handlers.put(handlerName, handler);
    }
}
