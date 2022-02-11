package com.design.pattern.singleton;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.springframework.core.ReactiveAdapterRegistry;

/**
 * 源码中的单例模式
 */
public class SourceCodeSingleton {
    public static void main(String[] args) {
        Runtime.getRuntime();//饿汉式单例模式
        ReactiveAdapterRegistry.getSharedInstance(); //双重检查锁单例模式
        TomcatURLStreamHandlerFactory.getInstance(); //双重检查锁单例模式
    }
}
