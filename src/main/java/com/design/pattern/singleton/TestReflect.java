package com.design.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazySingletonDcl instance = LazySingletonDcl.getInstance();

        Constructor<LazySingletonDcl> constructor = LazySingletonDcl.class.getDeclaredConstructor();
        constructor.setAccessible(true);//强制允许访问私有构造方法
        LazySingletonDcl lazySingletonDcl = constructor.newInstance();
        System.out.println(lazySingletonDcl==instance); //java.lang.IllegalStateException: 单例类不允许创建多个实例

    }
}
