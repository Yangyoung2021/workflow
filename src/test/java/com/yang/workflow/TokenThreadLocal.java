package com.yang.workflow;

public class TokenThreadLocal {

    private TokenThreadLocal() { }

    private static final ThreadLocal<String> tokenLocal = new ThreadLocal<>();

    public static void setToken(String token) {
        tokenLocal.set(token);
    }

    public static String getToken() {
        return tokenLocal.get();
    }


}
