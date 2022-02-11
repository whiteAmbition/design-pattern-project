package com.design.pattern.singleton;

/**
 * 使用内部类方式实现的单例模式
 */
public class InnerSingleton {

    public static String name="InnerSingleton name";
    static {
        System.out.println("InnerSingleton instance init");
    }

    private InnerSingleton() {
    }

    private static class InnerSingletonHolder {

        static {
            System.out.println("InnerSingletonHolder instance init");
        }

        private static InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance(){
        return InnerSingletonHolder.instance;
    }

}
