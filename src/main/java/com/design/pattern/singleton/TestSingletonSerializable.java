package com.design.pattern.singleton;

import java.io.*;

public class TestSingletonSerializable {
    public static void main(String[] args){
        SingletonSerializable singletonSerializable = SingletonSerializable.getInstance();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("SingletonSerializable"));
            objectOutputStream.writeObject(singletonSerializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SingletonSerializable singletonDeSerializable = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("SingletonSerializable"));
            singletonDeSerializable = (SingletonSerializable) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(singletonDeSerializable==singletonSerializable);
    }
}
