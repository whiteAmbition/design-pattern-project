package com.design.pattern.singleton;

/**
 * 懒汉式单例模式：双重检查锁+volatile禁止重排序
 */
public class LazySingletonDcl {

    private static volatile LazySingletonDcl instance = null;

    private LazySingletonDcl() {
        if(instance!=null){
            throw new IllegalStateException("单例类不允许创建多个实例"); //如果先执行反射，后调用getInstance方法，无法阻止反射创建新的实例
        }
    }

    public static LazySingletonDcl getInstance() {
        if (instance == null) {
            synchronized (LazySingletonDcl.class) {
                if (instance == null) {
                    instance = new LazySingletonDcl();
                }
            }
        }
        return instance;
    }

}
