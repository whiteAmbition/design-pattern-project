package com.design.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 对象序列化到磁盘或者远程服务器，服务器再执行反序列化就可以将对象恢复到JVM
 */
public class SingletonSerializable implements Serializable {

    private static final long serialVersionUID = 6062965282338163450L;
    public String name = "SingletonSerializable serialVersionUID = 6062965282338163450";

    private static SingletonSerializable instance = new SingletonSerializable();

    private SingletonSerializable() {

    }

    public static SingletonSerializable getInstance() {
        return instance;
    }

    /**
     * 重写readResolve返回单例类中的instance可以避面序列化反序列化破坏单例模式
     * @return
     * @throws ObjectStreamException
     */
    Object readResolve() throws ObjectStreamException{
        return getInstance();
    }

}
