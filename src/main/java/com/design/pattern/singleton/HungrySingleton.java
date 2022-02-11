package com.design.pattern.singleton;

/**
 * 饿汉式单例模式
 */
public class HungrySingleton {

    public static String name="HungrySingleton name";

    private static HungrySingleton instance = new HungrySingleton();

    static {
        System.out.println("HungrySingleton instance init");
        System.out.println(instance==null);
    }

    private HungrySingleton() {
        if(instance!=null){
            throw new IllegalStateException("单例类不允许创建多个实例");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
