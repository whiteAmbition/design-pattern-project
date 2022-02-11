package com.design.pattern.singleton;

public class TestInnerSingleton {
    public static void main(String[] args) {
        System.out.println(InnerSingleton.name);
        System.out.println("===========");
        System.out.println(InnerSingleton.getInstance());
    }
}
