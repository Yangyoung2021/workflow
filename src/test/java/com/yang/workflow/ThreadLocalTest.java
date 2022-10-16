package com.yang.workflow;

public class ThreadLocalTest {

    public static void main(String[] args) {
        new Thread(() -> {
            TokenThreadLocal.setToken("AAA");
            System.out.println(TokenThreadLocal.getToken());
        }).start();

        new Thread(() -> {
            TokenThreadLocal.setToken("BBB");
            System.out.println(TokenThreadLocal.getToken());
        }).start();
    }
}
