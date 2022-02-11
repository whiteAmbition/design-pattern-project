package com.design.pattern.factory;

/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使得一个类的实例化延迟到子类。
 * 开闭原则、单一职责、
 */
public class FactoryMethod {
    public static void main(String[] args) {
//        Application application = new Application();
//        Product product = application.getObject();
//        product.method1();
//        Product product2 = application.getObject("2");
//        product2.method1();

        Application concreteProductA1 = new ConcreteProductA1();
        Product productA1Object = concreteProductA1.getObject();
        productA1Object.method1();
        Application concreteProductA2 = new ConcreteProductA1();
        Product productA2 = concreteProductA2.getObject();
        productA2.method1();

    }
}

class SimpleFactory{
    public static Product createProduct(String type){
        if("1".equals(type)){
            return new ProductA1();
        }else if("2".equals(type)){
            return new ProductA2();
        }
        return null;
    }
}

interface Product{
    void method1();
}

class ProductA1 implements Product{
    @Override
    public void method1(){
        System.out.println("ProductA1.method1 executed.");
    }
}
class ProductA2 implements Product{
    @Override
    public void method1(){
        System.out.println("ProductA2.method1 executed.");
    }
}

abstract class Application{
    abstract Product createProduct();

    Product getObject(){
        Product product = createProduct();
        //...
        return product;
    }

    //简单工厂
    private Product createProduct(String type){
        //...init
        //...
        return SimpleFactory.createProduct(type);
    }
    Product getObject(String type){
        Product product = createProduct(type);
        //...
        return product;
    }
}

class ConcreteProductA1 extends Application{

    @Override
    Product createProduct() {
        return new ProductA1();
    }
}
class ConcreteProductA2 extends Application{

    @Override
    Product createProduct() {
        return new ProductA2();
    }
}
